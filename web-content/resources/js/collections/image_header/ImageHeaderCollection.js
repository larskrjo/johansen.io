define(['helper/Util',
        'collections/generic/base/BaseCollection',
        'models/image_header/ImageHeaderModel'],

    function(Util, BaseCollection, ImageHeaderModel){

      var ImageHeaderCollection = BaseCollection.extend({

        url: Util.Paths.URI_API_IMAGE_HEADER,

        model: ImageHeaderModel

      });

      return ImageHeaderCollection;
    }

);