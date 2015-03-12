require(['utils', 'backbone'],

  function(Utils, Backbone) {

    var User = Backbone.Model.extend({

      url: Utils.path().USERS

    });

  }

);