/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:31:48 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular
    .module('Aplikasi-Absensi', [
      'ui.router',
      'oc.lazyLoad',
      'ngCookies',
      'base64',
      'angular-loading-bar'
    ])
    .config(function($stateProvider, $urlRouterProvider, $httpProvider, cfpLoadingBarProvider) {

      cfpLoadingBarProvider.includeSpinner = true;

      $urlRouterProvider.otherwise('/home');

      $stateProvider
        .state('home', {
          url: '/home',
          views: {
            'lazyLoadView': {
              template: '<ng-home></ng-home>'
            }
          },
          resolve: {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
              return $ocLazyLoad.load([
                'scripts/services/url.service.js',
                'scripts/directives/ngHome.js',
                'scripts/services/asisten.service.js',
                'scripts/controllers/home.controller.js'
              ]);
            }]
          },
          authenticate: false
        })
        .state('asisten', {
          url: '/asisten',
          views: {
            'lazyLoadView': {
              template: '<ng-asisten></ng-asisten>'
            }
          },
          resolve: {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
              return $ocLazyLoad.load([
                'scripts/services/url.service.js',
                'scripts/directives/ngAsisten.js',
                'scripts/services/asisten.service.js',
                'scripts/controllers/asisten.controller.js'
              ]);
            }]
          },
          authenticate: false
        })
        .state('login', {
          url: '/login',
          views: {
            'lazyLoadView': {
              template: '<ng-authenticate></ng-authenticate>'
            }
          },
          resolve: {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
              return $ocLazyLoad.load([
                'scripts/services/url.service.js',
                'scripts/directives/ngAuthenticate.js',
                'scripts/services/authenticate.service.js',
                'scripts/controllers/authenticate.controller.js'
              ]);
            }]
          },
          authenticate: false
        })
        .state('absensi', {
          url: '/absensi',
          views: {
            'lazyLoadView': {
              template: '<ng-absensi></ng-absensi>'
            }
          },
          resolve: {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
              return $ocLazyLoad.load([
                'scripts/services/url.service.js',
                'scripts/directives/ngAbsensi.js',
                'scripts/services/absensi.service.js',
                'scripts/services/auth.service.js',
                'scripts/controllers/absensi.controller.js'
              ]);
            }]
          },
          authenticate: true
        });

      $httpProvider.interceptors.push(['$q', '$location', '$window', function($q, $location, $window) {
        return {
          'response': function(response) {
            if (response.status === 401) {
              console.log("Response 401");
            }
            return response || $q.when(response);
          },
          'responseError': function(rejection) {
            if (rejection.status === 401) {
              $window.location.href = '#/login';
            }
            if (rejection.status === 403) {
              $window.location.href = '#/login';
            }
            return $q.reject(rejection);
          }
        };
      }]);

    })
    .run(['$rootScope', '$state', 'cfpLoadingBar', 'AuthService', function($rootScope, $state, cfpLoadingBar, AuthService) {

      $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
        if (toState.authenticate && !AuthService.isAuthenticate()) {
          $state.go('login');
          event.preventDefault();
        } else {
          cfpLoadingBar.start();
        }
      });

      $rootScope.$on('$stateChangeSuccess', function() {
        cfpLoadingBar.complete();
      });

    }]);
})();
