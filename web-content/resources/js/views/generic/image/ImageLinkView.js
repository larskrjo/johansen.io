define(['helper/Util',
        'views/generic/base/BaseView',
        'text!templates/generic/image/ImageLinkTemplate.html'],

  function(Util, BaseView, ImageLinkTemplate) {

    var ImageLinkView = BaseView.extend({

      initView: function(options) {
        this.options = options;
        if (options.startRender) {
          this.startRender();
        }
      },

      startRender: function() {
        BaseView.prototype.initView.call(this, this.options, ImageLinkTemplate);

        this.render();
      },

      doRender: function() {
        var html = this.template({
          i18n: this.options.i18n,
          linkUrl: this.options.linkUrl,
          imageUrl: this.options.imageUrl
        });
        Util.showLoading();
        this.$el.html(html);

        this.image = this.$el.find('img');

        this.image.on('load', Util._.bind(function() {
          this.image.css('height', 'auto');
          Util.hideLoading();
        }, this));
      }

    });

    return ImageLinkView;
  }

);