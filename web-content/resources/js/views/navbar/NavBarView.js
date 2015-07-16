define(['helper/Util',
        'helper/CookieUtil',
        'router/Router',
        'views/generic/base/BaseView',
        'text!templates/navbar/NavBarTemplate.html'],

    function(Util, CookieUtil, Router, BaseView, HeaderTemplate) {

      var NavBarView = BaseView.extend({

        events: {
          'click #header-about': 'about',
          'click #header-home': 'home',
          'click #header-cv': 'cv',
          'click #header-login': 'login',
          'click #header-account': 'account'
        },

        initView: function(options) {
          BaseView.prototype.initView.call(this, options, HeaderTemplate);
          if (CookieUtil.getSessionId()) {
            this.listenTo(this.model, 'change', Util._.bind(function() {
              this.render(options);
              this._checkScroll();
            }, this));
            this.model.getResource();
          }

          this.render(options);

          this._listenForScroll();
        },

        doRender: function (options) {
          var html;
          if (CookieUtil.getSessionId()) {
            html = this.template({
              type: 'account',
              accountText: this.model.toJSON().firstName,
              i18n: Util.i18n.navBarTemplate
            });
          } else {
            html = this.template({
              type: 'login',
              accountText: Util.i18n.navBarTemplate.signIn,
              i18n: Util.i18n.navBarTemplate
            });
          }
          this.$el.html(html);
          if (options.noActiveTabs) {
            return;
          }
          var selector = '#header-' + options.activeTab;
          if (Util.$(selector).length && !Util.$(selector).hasClass('active')) {
            Util.$(selector).addClass('active');
          }
        },

        about: function () {
          Util.Backbone.history.navigate('about', true);
        },

        home: function () {
          Util.Backbone.history.navigate('', true);
        },

        cv: function () {
          Util.Backbone.history.navigate('cv', true);
        },

        login: function () {
          Util.Backbone.history.navigate('login', true);
        },

        account: function () {
          Util.Backbone.history.navigate('account', true);
        },

        _listenForScroll: function () {
          if (Util.$('#header nav').length > 0) {
            Util.$(window).on('scroll load resize', Util._.bind(function() {
              this._checkScroll();
            }, this));
          }
          // Initial check
          this._checkScroll();
        },

        _checkScroll: function () {
          if (Util.$(window).width() < 768) {
            if (!Util.$('#header nav').hasClass('scrolled')) {
              Util.$('#header nav').addClass('scrolled');
            }
            return;
          }
          // var startY = Util.$('#header nav').height();
          var startY = Util.$('#header nav').height();  //The point where the navbar changes in px

          if(Util.$(window).scrollTop() > startY){
            Util.$('#header nav').addClass('scrolled');
          }else{
            Util.$('#header nav').removeClass('scrolled');
          }
        }

      });

      return NavBarView;
    }

);