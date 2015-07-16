/* jshint maxparams: 6 */
define(['helper/Util',
        'helper/Routes',
        'router/Paths',
        'models/user/UserModel',
        'models/credentials/CredentialsModel',
        'views/generic/base/BaseView',
        'views/login/LoginFormView',
        'text!templates/home/HomeTemplate.html'],

    function(Util, Routes, Paths, UserModel, CredentialsModel, BaseView, LoginFormView, HomeTemplate) {

      var LoginView = BaseView.extend({

        initView: function(options) {
          BaseView.prototype.initView.call(this, options, HomeTemplate);
          this.options = options;

          if (options.NavBarView) {
            this.addChild(this, {
              elSelector: '#header',
              noActiveTabs: options.noActiveTabs,
              activeTab: 'login'
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
          if (!this.containsChild(LoginFormView)) {
            this.addChild(this, {
              elSelector: '.section-content-area',
            }, LoginFormView, CredentialsModel);
            return;
          }
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

      return LoginView;
    }

);