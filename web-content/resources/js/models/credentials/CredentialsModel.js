define(['helper/Util',
      'models/generic/base/BaseModel'],

    function(Util, BaseModel){

      var CredentialsModel = BaseModel.extend({

        urlRoot: Util.Paths.URI_API_AUTHENTICATE_USER,

        defaults: {
          email: '',
          password: ''
        }

      });

      return CredentialsModel;
    }

);