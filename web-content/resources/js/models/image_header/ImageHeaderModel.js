define(['helper/Util',
        'models/generic/base/BaseModel'],

  function(Util, BaseModel){

    var ImageHeaderModel = BaseModel.extend({

      urlRoot: Util.Paths.URI_API_IMAGE_HEADER

    });

    return ImageHeaderModel;
  }

);