/*jshint maxparams: 8, maxstatements: 15 */
define(['helper/Util',
      'router/Paths',
      'helper/Routes',
      'collections/image_header/ImageHeaderCollection',
      'models/image_section/ImageSectionModel',
      'models/user/UserModel',
      'views/generic/base/BaseView',
      'views/header/HeaderView',
      'views/generic/section/SectionView',
      'views/generic/image/ImageLinkView',
      'text!templates/cv/CvTemplate.html'],

    function(Util, Paths, Routes, ImageHeaderCollection, ImageSectionModel, UserModel, BaseView, HeaderView,
             SectionView, ImageLinkView, CvTemplate) {

      var AboutView = BaseView.extend({

        events: {
          'click #cv-resume-btn': 'downloadCvResume',
          'click #cv-harvard-transcripts-btn': 'downloadCvHarvardTranscripts',
          'click #cv-ntnu-transcripts-btn': 'downloadCvNtnuTranscripts'
        },

        initView: function(options) {
          BaseView.prototype.initView.call(this, options, CvTemplate);
          this.options = options;

          if (options.NavBarView) {
            this.addChild(this, {
              elSelector: '#header',
              noActiveTabs: options.noActiveTabs,
              activeTab: 'cv'
            }, options.NavBarView, UserModel);
          }

          this.render();
        },

        downloadCvResume: function() {
          window.open(Paths.URI_PATH_SECTION_CV, '');
        },

        downloadCvHarvardTranscripts: function () {
          window.open(Paths.URI_PATH_SECTION_HARVARD);
        },

        downloadCvNtnuTranscripts: function () {
          window.open(Paths.URI_PATH_SECTION_NTNU);
        },

        doRender: function() {
          var html = this.template();
          this.$el.html(html);
        },

        allViewsFinishedRender: function () {
          if (!this.containsChild(HeaderView)) {
            this.addChild(this, {
              elSelector: '#body-header',
              i18n: Util.i18n.headerTemplate_Cv
            }, HeaderView, null, ImageHeaderCollection);
            return;
          }

          if (!this.containsChildSelector('#cvResumeSection')) {
            var cvResumeImageView = this.addChild(this, {
              elSelector: '#cvResumeSection',
              content: true,
              startRender: false,
              linkUrl: Paths.URI_PATH_SECTION_CV,
              imageUrl: Paths.URI_PATH_SECTION_CV,
              i18n: Util.i18n.sectionTemplate_CvResumeImg
            }, ImageLinkView);
            cvResumeImageView.startRender();
            Util.activateAnimationFor('#cvResumeSection', 'fadeInLeft', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvResumeSectionSide')) {
            var cvResumeView = this.addChild(this, {
              elSelector: '#cvResumeSectionSide',
              header: true,
              content: true,
              footer: true,
              footerBtn: 'cv-resume-btn',
              noStyle: true,
              startRender: false,
              i18n: Util.i18n.sectionTemplate_CvResumeSide
            }, SectionView);
            cvResumeView.startRender();
            Util.activateAnimationFor('#cvResumeSectionSide', 'fadeIn', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvUsaSection')) {
            var cvResumeImageView = this.addChild(this, {
              elSelector: '#cvUsaSection',
              content: true,
              startRender: false,
              linkUrl: Paths.URI_PATH_SECTION_HARVARD,
              imageUrl: Paths.URI_PATH_SECTION_HARVARD,
              i18n: Util.i18n.sectionTemplate_CvTranscriptUsImg
            }, ImageLinkView);
            cvResumeImageView.startRender();
            Util.activateAnimationFor('#cvUsaSection', 'fadeInRight', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvUsaSectionSide')) {
            var cvResumeView = this.addChild(this, {
              elSelector: '#cvUsaSectionSide',
              header: true,
              content: true,
              footer: true,
              footerBtn: 'cv-harvard-transcripts-btn',
              noStyle: true,
              startRender: false,
              i18n: Util.i18n.sectionTemplate_CvTranscriptUsSide
            }, SectionView);
            cvResumeView.startRender();
            Util.activateAnimationFor('#cvUsaSectionSide', 'fadeIn', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvNorwaySection')) {
            var cvResumeImageView = this.addChild(this, {
              elSelector: '#cvNorwaySection',
              content: true,
              startRender: false,
              linkUrl: Paths.URI_PATH_SECTION_NTNU,
              imageUrl: Paths.URI_PATH_SECTION_NTNU,
              i18n: Util.i18n.sectionTemplate_CvTranscriptNoImg
            }, ImageLinkView);
            cvResumeImageView.startRender();
            Util.activateAnimationFor('#cvNorwaySection', 'fadeInLeft', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvNorwaySectionSide')) {
            var cvResumeView = this.addChild(this, {
              elSelector: '#cvNorwaySectionSide',
              header: true,
              content: true,
              footer: true,
              footerBtn: 'cv-ntnu-transcripts-btn',
              noStyle: true,
              startRender: false,
              i18n: Util.i18n.sectionTemplate_CvTranscriptNoSide
            }, SectionView);
            cvResumeView.startRender();
            Util.activateAnimationFor('#cvNorwaySectionSide', 'fadeIn', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvUsaSection1')) {
            var cvResumeImageView = this.addChild(this, {
              elSelector: '#cvUsaSection1',
              content: true,
              startRender: false,
              linkUrl: Paths.URI_PATH_SECTION_HARVARD,
              imageUrl: Paths.URI_PATH_SECTION_HARVARD,
              i18n: Util.i18n.sectionTemplate_CvTranscriptUsImg
            }, ImageLinkView);
            cvResumeImageView.startRender();
            Util.activateAnimationFor('#cvUsaSection1', 'fadeInRight', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvUsaSectionSide1')) {
            var cvResumeView = this.addChild(this, {
              elSelector: '#cvUsaSectionSide1',
              header: true,
              content: true,
              footer: true,
              footerBtn: 'cv-harvard-transcripts-btn',
              noStyle: true,
              startRender: false,
              i18n: Util.i18n.sectionTemplate_CvTranscriptUsSide
            }, SectionView);
            cvResumeView.startRender();
            Util.activateAnimationFor('#cvUsaSectionSide1', 'fadeIn', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvNorwaySection1')) {
            var cvResumeImageView = this.addChild(this, {
              elSelector: '#cvNorwaySection1',
              content: true,
              startRender: false,
              linkUrl: Paths.URI_PATH_SECTION_NTNU,
              imageUrl: Paths.URI_PATH_SECTION_NTNU,
              i18n: Util.i18n.sectionTemplate_CvTranscriptNoImg
            }, ImageLinkView);
            cvResumeImageView.startRender();
            Util.activateAnimationFor('#cvNorwaySection1', 'fadeInLeft', '0s');
            return;
          }

          if (!this.containsChildSelector('#cvNorwaySectionSide1')) {
            var cvResumeView = this.addChild(this, {
              elSelector: '#cvNorwaySectionSide1',
              header: true,
              content: true,
              footer: true,
              footerBtn: 'cv-ntnu-transcripts-btn',
              noStyle: true,
              startRender: false,
              i18n: Util.i18n.sectionTemplate_CvTranscriptNoSide
            }, SectionView);
            cvResumeView.startRender();
            Util.activateAnimationFor('#cvNorwaySectionSide1', 'fadeIn', '0s');
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