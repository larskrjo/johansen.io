define(['helper/Util',
      'views/generic/base/BaseView',
      'views/footer/FooterView',
      'views/navbar/NavBarView',
      'views/alert/AlertView'],

    function(Util, BaseView, FooterView, NavBarView, AlertView) {

      return Util.Backbone.Collection.extend({

        getResource: function() {
          return this.fetch({
            reset: true,
            error: function(model, response) {
              BaseView.prototype.error.call(this, response, AlertView, NavBarView, FooterView);
            }
          });
        },

        postResource: function(attributes) {
          return this.save(attributes, {
            error: function (model, response) {
              BaseView.prototype.error.call(this, response, AlertView, NavBarView, FooterView);
            }
          });
        },

        putResource: function(attributes) {
          return this.save(attributes, {
            error: function(model, response) {
              BaseView.prototype.error.call(this, response, AlertView, NavBarView, FooterView);
            }
          });
        },

        patchResource: function(attributes) {
          return this.save(attributes, {
            error: function(model, response) {
              BaseView.prototype.error.call(this, response, AlertView, NavBarView, FooterView);
            },
            patch: true
          });
        },

        deleteResource: function() {
          return this.destroy( {
            error: function(model, response) {
              BaseView.prototype.error.call(this, response, AlertView, NavBarView, FooterView);
            }
          });
        }

      });

    }

);