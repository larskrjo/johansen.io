define(['helper/Util',
        'models/generic/base/BaseModel'],

  function(Util, BaseModel){

    var ImageSectionModel = BaseModel.extend({

      urlRoot: Util.Paths.URI_API_IMAGE_SECTION

    });

    return ImageSectionModel;
  }

);