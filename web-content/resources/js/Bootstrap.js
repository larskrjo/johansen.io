var locale = 'us';
if (document.getElementById('locale') && document.getElementById('locale').innerHTML) {
  locale = document.getElementById('locale').innerHTML;
}

requirejs.config({

  baseUrl: '/resources/js',

  paths: {
    collections: 'collections',
    views: 'views',
    models: 'models',
    helper: 'helper',
    router: 'router',
    json: 'libs/json',
    backbone: 'libs/backbone',
    bootstrap: 'libs/bootstrap',
    jquery: 'libs/jquery',
    underscore: 'libs/underscore',
    handlebars: 'libs/handlebars',
    text: 'libs/text',
    i18n: 'libs/i18n',
    templates: '../templates',
    nls: '../nls'
  },

  shim: {
    json: {
      exports: 'JSON'
    },
    'backbone': {
      deps: ['underscore', 'jquery', 'json'],
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
  },

  config: {
    i18n: {
      locale: locale
    }
  }

});

require(['router/Router'],

  function(Router) {
    Router.initialize();
  }

);