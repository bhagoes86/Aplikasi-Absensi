/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 4:02:44 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .factory('AuthService', AuthService);

  AuthService.$inject = ['$cookies', '$state'];

  function AuthService($cookies, $state) {
    return {
      isAuthenticate: function() {
        if ($cookies.get('token')) {
          return true;
        } else {
          return false;
        }
      },
      logout: function() {
        $cookies.remove('token');
        $cookies.remove('refreshToken');
        $state.go('login');
      }
    };
  }

})();
