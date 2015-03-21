define(['helper/Util',
        'models/user/UserModel',
        'views/base/BaseView',
        'text!templates/user/UserTemplate.html'],

  function(Util, UserModel, BaseView, UserTemplate) {

    var UserView = BaseView.extend({

      initialize: function() {
        BaseView.prototype.initialize.call(this, UserTemplate, '#body');

        this.listenTo(this.model, 'change', this.render);
        this.model.getResource();
      },

      render: function() {
        this.$el.html(this.template(this.model.attributes));
        return this;
      }

    });

    return UserView;
  }

);