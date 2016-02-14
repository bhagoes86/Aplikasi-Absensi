/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:36:33 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .directive('ngAsisten', ngAsisten);

  ngAsisten.$inject = ['UrlService'];

  function ngAsisten(UrlService) {
    return {
      restrict: 'E',
      templateUrl: UrlService.asistenTemplate(),
      controller: 'AsistenController',
      controllerAs: 'asisten'
    };
  }

})();
