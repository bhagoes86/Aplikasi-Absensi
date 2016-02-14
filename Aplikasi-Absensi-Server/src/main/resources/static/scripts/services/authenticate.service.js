/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:34:29 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .factory('AuthenticateService', AuthenticateService);

  AuthenticateService.$inject = ['$http', 'UrlService', '$base64', '$cookies'];

  function AuthenticateService($http, UrlService, $base64, $cookies) {
    return {
      loginProcess: function(login) {

        var data = {
          client_id: 'clientapp',
          client_secret: 123456,
          scope: 'read',
          grant_type: 'password',
          username: login.npm,
          password: login.password
        };

        return $http({
          method: 'POST',
          url: UrlService.loginProcess(),
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
            'Authorization': 'Basic ' + $base64.encode('clientapp:123456')
          },
          data: $.param(data)
        });
      }
    };
  }

})();
