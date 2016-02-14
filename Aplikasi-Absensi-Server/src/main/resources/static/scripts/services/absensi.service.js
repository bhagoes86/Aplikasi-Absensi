/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:32:26 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .factory('AbsensiService', AbsensiService);

  AbsensiService.$inject = ['$http', 'UrlService', '$cookies'];

  function AbsensiService($http, UrlService, $cookies) {
    return {
      getAllAbsensiAsisten: function(page, size) {
        return $http({
          method: 'GET',
          url: UrlService.getAllAbsensiAsisten(page, size),
          headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + $cookies.get('token')
          }
        });
      }
    };
  }

})();
