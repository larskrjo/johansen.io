/*jshint maxparams: 15, maxstatements: 11, unused: false */
define(['helper/Util',
        'helper/CookieUtil',
        'helper/Routes',
        'router/base/BaseRouter',
        'models/image_full/ImageFullModel',
        'models/alert/AlertModel',
        'models/user/UserModel',
        'views/footer/FooterView',
        'views/navbar/NavBarView',
        'views/home/HomeView',
        'views/about/AboutView',
        'views/cv/CvView',
        'views/login/LoginView',
        'views/account/AccountView',
        'views/alert/AlertView'],

  function(Util, CookieUtil, Routes, BaseRouter, ImageFullModel, AlertModel, UserModel,
           FooterView, NavBarView, HomeView, AboutView, CvView, LoginView, AccountView, AlertView) {

    Util.setupUtil();

    var Router = BaseRouter.extend({

      routes: {
        '': 'home',
        'about': 'about',
        'login': 'login',
        'account': 'account',
        'cv': 'cv',
        'social/login': 'socialLogin',
        '*any': 'alert'
      }

    });

    var initialize = function() {
      var appRouter = new Router();

      /**
       * Define routes
       */
      appRouter.on('route:home', function() {
        displayView(HomeView);
      });
      appRouter.on('route:about', function() {
        displayView(AboutView);
      });
      appRouter.on('route:cv', function() {
        displayView(CvView);
      });
      appRouter.on('route:login', function() {
        if (CookieUtil.getSessionId()) {
          Util.Backbone.history.navigate('account', true);
        } else {
          displayView(LoginView);
        }
      });
      appRouter.on('route:account', function() {
        history.pushState("", document.title, window.location.pathname); // Remove trailing hashbang from Facebook.
        if (!CookieUtil.getSessionId()) {
          Util.Backbone.history.navigate('login', true);
        } else {
          displayView(AccountView);
        }
      });
      // It should default to alert view
      appRouter.on('route:alert', function() {
        displayViewAndModel(AlertView, AlertModel);
      });
      appRouter.on('route:socialLogin', function() {
        window.location.reload();
      });

      /**
       * Define default behavior
       */
      var displayView = function(View) {
        cleanUp();
        if (Util.$('#error-status-code').html().length) {
          appRouter.view = new AlertView({
            model: new AlertModel()
          });
        } else {
          appRouter.view = new View();
        }
        appRouter.view.initView({
          NavBarView: NavBarView,
          FooterView: FooterView,
          elSelector: '#body'
        });
      };
      var displayViewAndModel = function(View, Model, id) {
        cleanUp();
        if (Util.$('#error-status-code').html().length) {
          View = AlertView;
          Model = AlertModel;
          id = undefined;
        }
        appRouter.view = new View({
          model: id === undefined ? new Model() : new Model({id: id})
        });
        appRouter.view.initView({
          NavBarView: NavBarView,
          FooterView: FooterView,
          elSelector: '#body'
        })
      };
      var displayViewAndCollection = function(View, Collection) {
        cleanUp();
        if (Util.$('#error-status-code').html().length) {
          appRouter.view = new AlertView({
            model: new AlertModel()
          });
        } else {
          appRouter.view = new View({
            collection: new Collection()
          });
        }
        appRouter.view.initView({
          NavBarView: NavBarView,
          FooterView: FooterView,
          elSelector: '#body'
        })
      };
      var cleanUp = function() {
        if (appRouter.view) {
          appRouter.view.close();
        }
      };
      /**
       * Start router
       */
      Util.Backbone.history.start({
        pushState: true
      });
    };

    return {
      initialize: initialize
    };
  }

);