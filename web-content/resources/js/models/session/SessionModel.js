define(['helper/Util',
      'models/generic/base/BaseModel'],

    function(Util, BaseModel){

      var UserModel = BaseModel.extend({

        urlRoot: Util.Paths.URI_API_INVALIDATE_SESSION,

      });

      return UserModel;
    }

);