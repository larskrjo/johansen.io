/*jshint maxparams: 8, maxstatements: 15 */
define(['helper/Util',
      'helper/Routes',
      'router/Paths',
      'collections/image_header/ImageHeaderCollection',
      'models/image_section/ImageSectionModel',
      'models/user/UserModel',
      'views/generic/base/BaseView',
      'views/header/HeaderView',
      'views/generic/section/SectionView',
      'views/generic/image/ImageLinkView',
      'text!templates/about/AboutTemplate.html'],

    function(Util, Routes, Paths, ImageHeaderCollection, ImageSectionModel, UserModel, BaseView, HeaderView,
             SectionView, ImageLinkView, AboutTemplate) {

      var AboutView = BaseView.extend({

        initView: function(options) {
          BaseView.prototype.initView.call(this, options, AboutTemplate);
          this.options = options;

          if (options.NavBarView) {
            this.addChild(this, {
              elSelector: '#header',
              noActiveTabs: options.noActiveTabs,
              activeTab: 'about'
            }, options.NavBarView, UserModel);
          }

          this.render();
        },

        doRender: function() {
          var html = this.template();
          this.$el.html(html);
        },

        allViewsFinishedRender: function () {
          if (!this.containsChild(HeaderView)) {
            this.addChild(this, {
              elSelector: '#body-header',
              i18n: Util.i18n.headerTemplate_About
            }, HeaderView);
          }

          if (!this.containsChildSelector('#aboutGeneralSection')) {
            var aboutGeneralImageView = this.addChild(this, {
              elSelector: '#aboutGeneralSection',
              content: true,
              startRender: false,
              linkUrl: Paths.URI_PATH_SECTION_CV,
              imageUrl: Paths.URI_PATH_SECTION_CV,
              i18n: Util.i18n.sectionTemplate_CvResumeImg
            }, ImageLinkView);
            aboutGeneralImageView.startRender();
            Util.activateAnimationFor('#aboutGeneralSection', 'fadeInLeft', '0s');
            return;
          }

          if (!this.containsChildSelector('#aboutGeneralSectionSide')) {
            var aboutGeneralView = this.addChild(this, {
              elSelector: '#aboutGeneralSectionSide',
              header: true,
              content: true,
              footer: true,
              footerBtn: 'cv-resume-btn',
              noStyle: true,
              startRender: false,
              i18n: Util.i18n.sectionTemplate_CvResumeSide
            }, SectionView);
            aboutGeneralView.startRender();
            Util.activateAnimationFor('#aboutGeneralSectionSide', 'fadeIn', '0s');
            return;
          }

          if (!this.containsChildSelector('#aboutOktaSection')) {
            var aboutOktaImageView = this.addChild(this, {
              elSelector: '#aboutOktaSection',
              content: true,
              startRender: false,
              linkUrl: Paths.URI_PATH_SECTION_HARVARD,
              imageUrl: Paths.URI_PATH_SECTION_HARVARD,
              i18n: Util.i18n.sectionTemplate_CvTranscriptUsImg
            }, ImageLinkView);
            aboutOktaImageView.startRender();
            Util.activateAnimationFor('#aboutOktaSection', 'fadeInRight', '0s');
            return;
          }

          if (!this.containsChildSelector('#aboutOktaSectionSide')) {
            var aboutOktaView = this.addChild(this, {
              elSelector: '#aboutOktaSectionSide',
              header: true,
              content: true,
              footer: true,
              footerBtn: 'cv-harvard-transcripts-btn',
              noStyle: true,
              startRender: false,
              i18n: Util.i18n.sectionTemplate_CvTranscriptUsSide
            }, SectionView);
            aboutOktaView.startRender();
            Util.activateAnimationFor('#aboutOktaSectionSide', 'fadeIn', '0s');
            return;
          }

          if (!this.containsChild(this.options.FooterView)) {
            var FooterView = this.options.FooterView;
            this.addChild(this, {
              elSelector: '#footer',
            }, FooterView);
            return;
          }
          Util.hideLoading();
          BaseView.prototype.allViewsFinishedRender.call(this);
        }

      });

      return AboutView;
    }

);