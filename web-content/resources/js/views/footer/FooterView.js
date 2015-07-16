define(['helper/Util',
      'views/generic/base/BaseView',
      'text!templates/footer/FooterTemplate.html'],

    function(Util, BaseView, FooterTemplate) {

      var FooterView = BaseView.extend({

        initView: function(options) {
          BaseView.prototype.initView.call(this, options, FooterTemplate);

          this.render();
        },

        doRender: function() {
          var html = this.template({
            i18n: Util.i18n.footerTemplate
          });
          this.$el.html(html);

          Util.activateAnimationFor('.icon-left > span', 'jello', '0.1s');
          Util.activateAnimationFor('.icon-center > span', 'jello', '0.2s');
          Util.activateAnimationFor('.icon-right > span', 'jello', '0.3s');
        }

      });

      return FooterView;
    }

);