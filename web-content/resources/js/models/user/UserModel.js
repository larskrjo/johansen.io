define(['helper/Util',
      'models/generic/base/BaseModel'],

    function(Util, BaseModel){

      var UserModel = BaseModel.extend({

        urlRoot: Util.Paths.URI_API_USER_ME,

        defaults: {
          email: '',
          firstName: '',
          lastName: '',
          profilePicture: '',
          locale: ''
        }

      });

      return UserModel;
    }

);