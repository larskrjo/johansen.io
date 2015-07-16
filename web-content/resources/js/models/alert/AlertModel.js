define(['helper/Util',
        'models/generic/base/BaseModel'],

  function(Util, BaseModel){

    var AlertModel = BaseModel.extend({

      urlRoot: Util.Paths.URI_ROUTE_HOME,

      defaults: {
        errorStatusCode: Util.$('#error-status-code').html(),
        errorCode: Util.$('#error-code').html(),
        errorMessage: Util.$('#error-message').html()
      }

    });

    return AlertModel;
  }

);