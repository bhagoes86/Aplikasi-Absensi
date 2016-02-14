/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:32:54 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .directive('ngAbsensi', ngAbsensi);

  ngAbsensi.$inject = ['UrlService'];

  function ngAbsensi(UrlService) {
    return {
      restrict: 'E',
      templateUrl: UrlService.absensiTemplate(),
      controller: 'AbsensiController',
      controllerAs: 'absensi'
    };
  }

})();
