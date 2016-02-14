/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 9:53:45 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Client
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

angular
  .module('Aplikasi-Absensi', [
    'ionic',
    'ngCordova'
  ])
  .run(['$rootScope', '$state', 'AuthService', '$ionicPlatform', function($rootScope, $state, AuthService, $ionicPlatform) {

    $ionicPlatform.ready(function() {
      if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
        cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
        cordova.plugins.Keyboard.disableScroll(true);
      }
      if (window.StatusBar) {
        StatusBar.styleDefault();
      }
    });

    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
      if (toState.authenticate && !AuthService.isAuthenticate()) {
        $state.go('tab.login');
        event.preventDefault();
      }
    });

  }])
  .config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/tab/home');

    $stateProvider
      .state('tab', {
        url: '/tab',
        abstract: true,
        templateUrl: 'templates/tabs.html',
        authenticate: false
      })
      .state('tab.home', {
        url: '/home',
        views: {
          'tab-home': {
            templateUrl: 'templates/home.template.html'
          }
        },
        authenticate: false
      })
      .state('tab.login', {
        url: '/login',
        views: {
          'tab-login': {
            templateUrl: 'templates/authenticate.template.html',
            controller: 'AuthenticateController'
          }
        },
        authenticate: false
      })
      .state('tab.absensi', {
        url: '/absensi',
        views: {
          'tab-absensi': {
            templateUrl: 'templates/absensi.template.html'
          }
        },
        authenticate: true
      });

  });
