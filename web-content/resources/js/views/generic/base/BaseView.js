/*jshint -W031 */
/**
 * Created by Lars Johansen
 */
define(['helper/Util',
        'helper/shadow/AlertModel'],

  function(Util, AlertModel) {

    var BaseView = Util.Backbone.View.extend({

      initialize: function() {
        this._childViews = [];
        this._childViewSelectors = [];
        this._rendered = false;
      },

      initView: function(options, Template) {
        this.parentView = options.parentView;
        this.template = Util.Handlebars.compile(Template);
        var randomId = Util.getRandomCharacters(20);
        Util.$(options.elSelector).html('<div id=\'' + randomId + '-view\'></div>');
        this.setElement('#' + randomId + '-view');
      },

      render: function (options) {
        this.doRender(options);
        this._rendered = true;
        if (this._areAllViewsRendered()) {
          this.allViewsFinishedRender();
        }
      },

      error: function(response, View, NavBarView, FooterView) {
        var view = new View({
          model: new AlertModel({
            errorStatusCode: Util.JSON.parse(response.responseText).errorStatusCode,
            errorCode: Util.JSON.parse(response.responseText).errorCode,
            errorMessage: Util.JSON.parse(response.responseText).errorMessage
          })
        });
        view.initView({
          NavBarView: NavBarView,
          FooterView: FooterView
        })
      },

      close: function () {
        this.remove();
        this.unbind();
        if (this.onClose){
          this.onClose();
        }
        Util._.each(this._childViews, function(childView){
          if (childView.close){
            childView.close();
          }
        });
      },

      _finishedRenderChildren: function () {
        if (this._areAllViewsRendered()) {
          this.allViewsFinishedRender();
        }
      },

      _areAllViewsRendered: function () {
        var rendered = this._rendered;
        Util._.each(this._childViews, function(childView){
          if (!childView._areAllViewsRendered()) {
            rendered = false;
          }
        });
        return rendered;
      },

      onClose: function () {
        // to unbind events and clean up errors
      },

      doRender: function () {
        // to be overridden
      },

      allViewsFinishedRender: function () {
        // Can be overridden for display ordering,
        // but must call the super class in the end.
        if (this.parentView) {
          this.parentView._finishedRenderChildren(this);
        }
      },

      containsChild: function (Prototype) {
        var exists = false;
        Util._.each(this._childViews, function(childView){
          if (Prototype != undefined &&
              Object.getPrototypeOf(childView) === Prototype.prototype) {
            exists = true;
          }
        });
        return exists;
      },

      containsChildSelector: function (Selector) {
        var exists = false;
        Util._.each(this._childViewSelectors, function(selector){
          if (Selector != undefined &&
              selector === Selector) {
            exists = true;
          }
        });
        return exists;
      },

      addChild: function (parent, options, View, Model, Collection) {
        var opts = Util._.extend(options, {
          parentView: parent
        });
        var view;
        if (Collection) {
          view = new View({
            collection: new Collection(opts.collectionOptions)
          });
        } else if (Model) {
          view = new View({
            model: new Model(opts.modelOptions)
          });
        } else {
          view = new View();
        }
        this._childViews.push(view);
        this._childViewSelectors.push(options.elSelector);
        view.initView(opts);
        return view;
      }

    });

    return BaseView;
  }

);