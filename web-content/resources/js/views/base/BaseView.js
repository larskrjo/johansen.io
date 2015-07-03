/**
 * Created by Lars Johansen
 */
define(['helper/Util',
        'views/error/AlertView'],

  function(Util, AlertView) {

    var BaseView = Util.Backbone.View.extend({

      initialize: function(Template, Selector) {
        this.template = Util.Handlebars.compile(Template);
        this.setElement(Selector);
      },

      error: function(response) {
        AlertView.prototype.showError.call(new AlertView(), response.responseJSON);
      }

    });

    return BaseView;
  }

);