define(['helper/Util',
        'views/generic/base/BaseView',
        'text!templates/generic/section/SectionTemplate.html'],

  function(Util, BaseView, SectionTemplate) {

    var SectionView = BaseView.extend({

      initView: function(options) {
        this.options = options;
        if (options.startRender) {
          this.startRender();
        }
      },

      startRender: function() {
        BaseView.prototype.initView.call(this, this.options, SectionTemplate);

        this.render();
      },

      doRender: function() {
        var html = this.template({
          header: this.options.header,
          content: this.options.content,
          noMargin: this.options.noMargin,
          noStyle: this.options.noStyle,
          footer: this.options.footer,
          footerBtn: this.options.footerBtn,
          i18n: this.options.i18n
        });
        this.$el.html(html);
      }

    });

    return SectionView;
  }

);