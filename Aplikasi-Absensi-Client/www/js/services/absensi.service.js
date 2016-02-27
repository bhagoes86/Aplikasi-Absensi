/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 9:55:19 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Client
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

angular.module('Aplikasi-Absensi')
  .factory('AbsensiService', ['$http', function($http) {

    //var baseUrl = 'http://192.168.2.116:8080';
    var baseUrl = 'http://absensi-asisten.rhcloud.com';

    return {
      simpanAbsensiAsisten: function(absensi) {
        return $http.post(baseUrl + '/api/absensi', absensi);
      },
      checkNpmAsisten: function(npm) {
        return $http.get(baseUrl + '/api/asisten/' + npm);
      }
    };

  }]);
