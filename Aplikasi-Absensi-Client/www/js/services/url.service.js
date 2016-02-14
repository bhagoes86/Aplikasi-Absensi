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
  .service('UrlService', [function() {

    var baseUrl = 'http://127.0.0.1:8080/';

    return {
      loginProcess: function() {
        return baseUrl + 'api/auth';
      }
    }
  }]);
