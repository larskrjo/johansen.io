define(['helper/Util',
        'models/generic/base/BaseModel'],

  function(Util, BaseModel){

    var ImageFullModel = BaseModel.extend({

      urlRoot: Util.Paths.URI_API_IMAGE_FULL

    });

    return ImageFullModel;
  }

);