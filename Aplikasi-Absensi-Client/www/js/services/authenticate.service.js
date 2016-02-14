/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 9:55:34 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Client
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

angular.module('Aplikasi-Absensi')
  .factory('AuthenticateService', ['$http', 'UrlService', function($http, UrlService) {
    return {
      loginProcess: function(login) {
        return $http.post(UrlService.loginProcess(), login);
      }
    };
  }]);
