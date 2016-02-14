/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 10:04:32 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Client
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

angular.module('Aplikasi-Absensi')
  .service('AuthService', ['$window', function($window) {
    return {
      isAuthenticate: function() {
        if ($window.localStorage.getItem('token')) {
          return true;
        } else {
          return false;
        }
      }
    }
  }]);
