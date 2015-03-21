/*jshint maxparams: 6 */
define(['backbone',
        'bootstrap',
        'jquery',
        'underscore',
        'handlebars',
        'router/Paths'],

  function(Backbone, Bootstrap, $, _, Handlebars, Paths) {

    return {
        Backbone: Backbone,
        Bootstrap: Bootstrap,
        $: $,
        _: _,
        Handlebars: Handlebars,
        Paths: Paths
    };
  }

);