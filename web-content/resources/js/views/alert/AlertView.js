define(['helper/Util',
        'helper/CookieUtil',
        'views/generic/base/BaseView',
        'text!templates/alert/AlertTemplate.html'],

  function(Util, CookieUtil, BaseView, AlertTemplate) {

    var AlertView = BaseView.extend({

      initView: function(options) {
        BaseView.prototype.initView.call(this, options, AlertTemplate);
        this.options = options;

        Util.hideLoading();

        if (options.NavBarView) {
          CookieUtil.deleteSession();
          this.addChild(this, {
            elSelector: '#header',
            noActiveTabs: options.noActiveTabs,
            activeTab: 'alert'
          }, options.NavBarView);
        }

        this.render(this.model.toJSON());
      },

      doRender: function(response) {
        var html = this.template(Util._.extend(response, {
          i18n: Util.i18n.alertTemplate
        }));
        this.$el.html(html);
      },

      onClose: function () {
        Util.$('#error-status-code').html('');
        Util.$('#error-code').html('');
        Util.$('#error-message').html('');
      },

      allViewsFinishedRender: function () {
        if (!this.containsChild(this.options.FooterView)) {
          var FooterView = this.options.FooterView;
          this.addChild(this, {
            elSelector: '#footer'
          }, FooterView);
          return;
        }
        BaseView.prototype.allViewsFinishedRender.call(this);
      }

    });

    return AlertView;
  }

);