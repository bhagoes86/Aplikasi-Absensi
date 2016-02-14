/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:33:40 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  angular.module('Aplikasi-Absensi')
    .service('UrlService', UrlService);

  function UrlService() {
    return {
      homeTemplate: function() {
        return 'templates/home.template.html';
      },
      asistenTemplate: function() {
        return 'templates/asisten.template.html';
      },
      absensiTemplate: function() {
        return 'templates/absensi.template.html';
      },
      authenticateTemplate: function() {
        return 'templates/authenticate.template.html';
      },
      registrasiAsisten: function() {
        return 'api/asisten';
      },
      loginProcess: function() {
        return 'oauth/token';
      }
    };
  }

})();
