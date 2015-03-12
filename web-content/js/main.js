requirejs.config({

  baseUrl: 'libs',

  paths: {
    views: '../views',
    models: '../models',
    helper: '../helper',
    app: '../app'
  },

  shim: {
    'backbone': {
      deps: ['underscore', 'jquery'],
      exports: 'backbone'
    },
    'underscore': {
      exports: '_'
    }
  }

});

require(['path']);
require(['app/main']);