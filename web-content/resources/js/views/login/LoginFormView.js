define(['helper/Util',
        'helper/Routes',
        'models/credentials/CredentialsModel',
        'views/generic/base/BaseView',
        'text!templates/login/LoginFormTemplate.html'],

    function(Util, Routes, CredentialsModel, BaseView, LoginFormTemplate) {

      var LoginFormView = BaseView.extend({

        events: {
          'click #login-submit' : 'login',
          'click #login-facebook' : 'loginFacebook'
        },

        initView: function(options) {
          BaseView.prototype.initView.call(this, options, LoginFormTemplate);

          this.listenTo(this.model, 'sync', this.showAccount);

          this.render();
        },

        doRender: function() {
          var html = this.template({
            i18n: Util.i18n.loginFormTemplate
          });
          this.$el.html(html);

          Util.activateAnimationFor('#login-form-template_heading', 'fadeInDown', '0s');
          Util.activateAnimationFor('#login-form-template_content', 'fadeInUp', '0s');
        },

        login: function () {
          var email = Util.$('#login-email').val();
          var password = Util.$('#login-password').val();
          this.model.set('email', email);
          this.model.set('password', password);
          this.model.postResource();
        },

        loginFacebook: function () {
          Util.Backbone.history.navigate('social/login', true);
        },

        showAccount: function () {
          Util.Backbone.history.navigate('account', true);
        }

      });

      return LoginFormView;
    }

);