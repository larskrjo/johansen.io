define(['helper/Util',
        'models/base/BaseModel'],

  function(Util, BaseModel){

    var UserModel = BaseModel.extend({

      urlRoot: Util.Paths.URI_USERS

    });

    return UserModel;
  }

);