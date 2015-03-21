requirejs.config({

  baseUrl: '/resources/js',

  paths: {
    views: 'views',
    models: 'models',
    helper: 'helper',
    router: 'router',
    backbone: 'libs/backbone',
    bootstrap: 'libs/bootstrap',
    jquery: 'libs/jquery',
    underscore: 'libs/underscore',
    handlebars: 'libs/handlebars',
    text: 'libs/text',
    templates: '../templates'
  },

  shim: {
    'backbone': {
      deps: ['underscore', 'jquery'],
      exports: 'backbone'
    },
    'bootstrap': {
      deps: ['jquery'],
      exports: 'bootstrap'
    },
    'underscore': {
      exports: 'underscore'
    },
    'jquery': {
      exports: 'jquery'
    },
    'handlebars': {
      exports: 'handlebars'
    }
  }

});

require(['router/Router'],

  function(Router) {
    Router.initialize();
  }

);