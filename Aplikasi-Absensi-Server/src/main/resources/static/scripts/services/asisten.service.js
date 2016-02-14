/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:34:36 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .factory('AsistenService', AsistenService);

  AsistenService.$inject = ['$http', 'UrlService'];

  function AsistenService($http, UrlService) {
    return {
      registrasiAsisten: function(asisten) {
        return $http.post(UrlService.registrasiAsisten(), asisten);
      }
    };
  }

})();
