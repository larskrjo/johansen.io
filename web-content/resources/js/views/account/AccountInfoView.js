define(['helper/Util',
        'helper/CookieUtil',
        'router/Paths',
        'models/session/SessionModel',
        'views/generic/base/BaseView',
        'text!templates/account/AccountInfoTemplate.html'],

    function(Util, CookieUtil, Paths, SessionModel, BaseView, AccountInfoTemplate) {

      var AccountInfoView = BaseView.extend({

        events: {
          'click #logout-submit' : 'logout',
          'click #flag-no' : 'setLocaleNo',
          'click #flag-us' : 'setLocaleUs'
        },

        initView: function(options) {
          BaseView.prototype.initView.call(this, options, AccountInfoTemplate);

          this.listenTo(this.model, 'change', this.render);
          this.model.getResource();

          this.sessionModel = new SessionModel({
            id: CookieUtil.getSessionId()
          });
          this.listenTo(this.sessionModel, 'sync', this.loggedOut);
        },

        doRender: function() {
          var locale = $('#locale').html();
          if (!locale) {
            locale = 'us'
          }
          var localeString;
          if (locale == 'no') {
            localeString = 'Norsk';
          } else if (locale == 'us') {
            localeString = 'English';
          }
          var html = this.template(
              Util._.extend(this.model.toJSON(), {
                i18n: Util.i18n.accountInfoTemplate,
                locale: localeString
              })
          );
          this.$el.html(html);

          Util.$('#flag-' + locale).attr('disabled', 'disabled');

          Util.activateAnimationFor('#account-info-template_heading', 'fadeInDown', '0s');
          Util.activateAnimationFor('#account-info-template_content_info', 'fadeInRight', '0s');
          Util.activateAnimationFor('#account-info-template_content_menu', 'fadeInUp', '0s');
        },

        logout: function () {
          this.sessionModel.deleteResource();
        },

        setLocaleNo: function () {
          this.listenTo(this.model, 'sync', this.reload);
          this.model.set('locale', 'no');
          this.model.putResource();
        },

        setLocaleUs: function () {
          this.listenTo(this.model, 'sync', this.reload);
          this.model.set('locale', 'us');
          this.model.putResource();
        },

        reload: function () {
          window.location.reload();
        },

        loggedOut: function () {
          CookieUtil.deleteSession();
          Util.Backbone.history.navigate(Paths.URI_ROUTE_LOGIN, true);
        }

      });

      return AccountInfoView;
    }

);