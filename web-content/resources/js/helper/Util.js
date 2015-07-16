/*jshint maxparams: 7 */
define(['backbone',
        'bootstrap',
        'jquery',
        'underscore',
        'handlebars',
        'json',
        'router/Paths',
        'i18n!nls/i18n'],

  function(Backbone, Bootstrap, $, _, Handlebars, JSON, Paths, i18n) {

    return {
      Backbone: Backbone,
      Bootstrap: Bootstrap,
      $: $,
      _: _,
      JSON: JSON,
      Handlebars: Handlebars,
      Paths: Paths,
      i18n: i18n,

      setupUtil: function () {
        // Setup function so we can add class to element when in display area.
        var $ = this.$;
        $.fn.inViewport = function(cb) {
          return this.each(function(i,el){
            function visPx(){
              var H = $(this).height(),
                  r = el.getBoundingClientRect(), t=r.top, b=r.bottom;
              return cb.call(el, Math.max(0, t>0? H-t : (b<H?b:H)));
            } visPx();
            $(window).on("resize scroll", visPx);
          });
        };

        // Enable loading for ajax calls.
        $(document).ajaxStart(_.bind(function () {
          this.showLoading();
        }, this));
        $(document).ajaxComplete(_.bind(function () {
          this.hideLoading();
        }, this));
      },

      showLoading: function () {
        this.$('#loading').show();
      },

      hideLoading: function () {
        this.$('#loading').fadeOut();
      },

      activateAnimationFor: function(selector, animationClass, delay) {
        this.$(selector).inViewport(this._.bind(function(px){
          if(px) {
            if (!this.$(selector).hasClass('animated')) {
              this.$(selector).addClass('animated');
              this.$(selector).addClass(animationClass);
              this.$(selector).css('animation-delay', delay);
            }
          }
        }, this));
      },

      getRandomCharacters: function(size) {
        var text = '';
        var possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
        for(var i = 0; i < size; i++) {
          text += possible.charAt(Math.floor(Math.random() * possible.length));
        }
        return text;
      }

    };
  }

);