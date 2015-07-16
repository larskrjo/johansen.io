define(['helper/Util',
      'router/Paths',
      'views/generic/base/BaseView',
      'text!templates/header/HeaderTemplate.html'],

    function(Util, Paths, BaseView, HeaderTemplate) {

      var HeaderView = BaseView.extend({

        initView: function(options) {
          BaseView.prototype.initView.call(this, options, HeaderTemplate);
          this.options = options;

          this.render();
        },

        doRender: function() {
          var html = this.template({
            i18n: this.options.i18n,
            urlHeader1: Paths.URI_PATH_HEADER_BACKGROUND_A,
            urlHeader2: Paths.URI_PATH_HEADER_BACKGROUND_B,
            urlHeader3: Paths.URI_PATH_HEADER_BACKGROUND_C,
            urlHeader4: Paths.URI_PATH_HEADER_BACKGROUND_D,
          });

          Util.showLoading();
          this.$el.html(html);

          this.image = this.$el.find('img');

          this.image.on('load', Util._.bind(function() {
            this.image.css('height', 'auto');
            Util.hideLoading();
          }, this));

          Util.activateAnimationFor('#post-header_title', 'fadeInDown', '0s');
        }

      });

      return HeaderView;
    }

);