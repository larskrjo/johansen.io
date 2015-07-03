define(['helper/Util',
        'router/base/BaseRouter',
        'models/user/UserModel',
        'views/user/UserView',
        'views/error/AlertView'],

  function(Util, BaseRouter, UserModel, UserView, AlertView) {

    var Router = BaseRouter.extend({

      routes: {
        '': 'home',
        '*actions': 'defaultAction'
      }

    });

    var displayError = function() {
      var response = {
        statusCode: Util.$('#statusCode').html(),
        errorCode: Util.$('#errorCode').html(),
        errorMessage: Util.$('#errorMessage').html()
      };
      AlertView.prototype.showError.call(new AlertView(), response);
    };

    var initialize = function() {
      var appRouter = new Router();

      appRouter.on('route:home', function() {
        if (!Util.$('#hasError').length) {
          displayView(UserView, UserModel);
        } else {
          displayError();
        }
      });

      appRouter.on('route:defaultAction', function() {
        // It should default to error view
        displayError();
      });

      var displayView = function(View, Model) {
        appRouter.view = new View({
          model: new Model()
        });
      };

      Util.Backbone.history.start({
        pushState: true
      });
    };

    return {
      initialize: initialize
    };
  }

);