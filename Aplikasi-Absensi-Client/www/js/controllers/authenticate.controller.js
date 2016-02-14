/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 9:55:47 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Client
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

angular.module('Aplikasi-Absensi')
  .controller('AuthenticateController', ['$scope', 'AuthenticateService', '$state', '$window', function($scope, AuthenticateService, $state, $window) {

    $scope.inputLogin = {};

    $scope.loginProcess = function(l) {
      AuthenticateService.loginProcess(l).success(function successCallback(response) {
        if (response.status === false) {
          alert(response.info);
        } else {
          $window.localStorage.setItem('token', response.token);
          alert(response.info);
          $state.go('tab.absensi');
        }
      });
    };

  }])
