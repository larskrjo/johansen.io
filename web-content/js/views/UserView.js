require(['utils', 'backbone', '_'],

  function(Utils, Backbone, _) {

    var UserView = Backbone.View.extend({

      el: 'h1',

      template: _.template('<p> default template </p>'),

      initialize: function() {
        this.template = '<p> initialized! </p>';
      },

      render: function() {

        this.$el.html(this.template);
        return this;
      }
    });

  }

);