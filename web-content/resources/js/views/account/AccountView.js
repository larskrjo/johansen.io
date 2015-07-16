define(['helper/Util',
        'router/Paths',
        'helper/Routes',
        'models/user/UserModel',
        'views/generic/base/BaseView',
        'views/account/AccountInfoView',
        'text!templates/home/HomeTemplate.html'],

  function(Util, Paths, Routes, UserModel, BaseView, AccountInfoView, HomeTemplate) {

    var AccountView = BaseView.extend({

      initView: function(options) {
        BaseView.prototype.initView.call(this, options, HomeTemplate);
        this.options = options;

        if (options.NavBarView) {
          this.addChild(this, {
            elSelector: '#header',
            noActiveTabs: options.noActiveTabs,
            activeTab: 'account'
          }, options.NavBarView, UserModel);
        }

        this.render();
      },

      doRender: function() {
        var html = this.template({
          urlBackground: Paths.URI_PATH_MAIN_BACKGROUND
        });
        this.$el.html(html);
      },

      allViewsFinishedRender: function () {
        if (!this.containsChild(AccountInfoView)) {
          this.addChild(this, {
            elSelector: '.section-content-area',
          }, AccountInfoView, UserModel);
          return;
        }
        if (!this.containsChild(this.options.FooterView)) {
          var FooterView = this.options.FooterView;
          this.addChild(this, {
            elSelector: '#footer'
          }, FooterView);
          return;
        }
        BaseView.prototype.allViewsFinishedRender.call(this);
      }

    });

    return AccountView;
  }

);