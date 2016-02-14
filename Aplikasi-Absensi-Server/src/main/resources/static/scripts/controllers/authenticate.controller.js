/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:36:56 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .controller('AuthenticateController', AuthenticateController);

  AuthenticateController.$inject = ['$cookies', 'AuthenticateService', '$state'];

  function AuthenticateController($cookies, AuthenticateService, $state) {
    var auth = this;

    auth.inputLogin = {};

    auth.loginProcess = function(l) {

      AuthenticateService.loginProcess(l).success(function successCallback(response) {
        $cookies.put('token', response.access_token);
        $cookies.put('refreshToken', response.refresh_token);
        swal('Info', 'anda berhasil login :)', 'success');
        $state.go('absensi');
      }).error(function(data, status) {
        if (status === 401) {
          swal('Warning', 'maaf username dan password anda masih salah :(', 'error');
        } else if (status === 400) {
          swal('Warning', 'maaf password anda masih salah :(', 'error');
        }
      });
    };

  }

})();
