define(['helper/Util',
        'text!templates/error/AlertTemplate.html'],

  function(Util, AlertTemplate) {

    var AlertView = Util.Backbone.View.extend({

      el: Util.$('.in-page-alert').length ? '.in-page-alert' : '#body',
      template: Util.Handlebars.compile(AlertTemplate),

      compileTemplate: function(response) {
        return this.template({
          statusCode: response.statusCode,
          errorCode: response.errorCode,
          errorMessage: response.errorMessage
        });
      },

      showError: function(response) {
        var html = this.compileTemplate(response);
        this.$el
          .removeClass('error success warning')
          .addClass('this-type-of-error')
          .html(html)
          .fadeIn();
      }

    });

    return AlertView;
  }

);