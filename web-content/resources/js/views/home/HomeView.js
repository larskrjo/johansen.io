define(['helper/Util',
        'router/Paths',
        'helper/Routes',
        'models/user/UserModel',
        'views/generic/base/BaseView',
        'text!templates/home/HomeTemplate.html'],

  function(Util, Paths, Routes, UserModel, BaseView, HomeTemplate) {

    var HomeView = BaseView.extend({

      initView: function(options) {
        BaseView.prototype.initView.call(this, options, HomeTemplate);
        this.options = options;

        if (options.NavBarView) {
          this.addChild(this, {
            elSelector: '#header',
            noActiveTabs: options.noActiveTabs,
            activeTab: 'home'
          }, options.NavBarView, UserModel);
        }

        this.render();
      },

      doRender: function() {
        var html = this.template({
          i18n: Util.i18n.homeTemplate,
          urlBackground: Paths.URI_PATH_MAIN_BACKGROUND
        });
        this.$el.html(html);
      },

      allViewsFinishedRender: function () {
        if (!this.containsChild(this.options.FooterView)) {
          var FooterView = this.options.FooterView;
          this.addChild(this, {
            elSelector: '#footer',
          }, FooterView);
          return;
        }
        Util.hideLoading();
        BaseView.prototype.allViewsFinishedRender.call(this);
      }

    });

    return HomeView;
  }

);