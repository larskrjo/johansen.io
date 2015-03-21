define(['helper/Util',
        'views/base/BaseView'],

  function(Util, BaseView){

    var BaseModel = Util.Backbone.Model.extend({

      getResource: function() {
        return this.fetch({
          error: function(model, response) {
            BaseView.prototype.error.call(this, response);
          }
        });
      },

      postResource: function(attributes) {
        return this.save(attributes, {
          error: function (model, response) {
            BaseView.prototype.error.call(this, response);
          }
        });
      },

      putResource: function(attributes) {
        return this.save(attributes, {
          error: function(model, response) {
            BaseView.prototype.error.call(this, response);
          }
        });
      },

      patchResource: function(attributes) {
        return this.save(attributes, {
          error: function(model, response) {
            BaseView.prototype.error.call(this, response);
          },
          patch: true
        });
      },

      deleteResource: function() {
        return this.destroy( {
          error: function(model, response) {
            BaseView.prototype.error.call(this, response);
          }
        });
      }

    });

    return BaseModel;
  }

);