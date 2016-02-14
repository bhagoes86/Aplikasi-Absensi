/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:38:06 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .directive('ngHome', ngHome);

  ngHome.$inject = ['UrlService'];

  function ngHome(UrlService) {
    return {
      restrict: 'E',
      templateUrl: UrlService.homeTemplate()
    };
  }

})();
