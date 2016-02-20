/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 20, 2016
 * @Time 10:00:04 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .directive('ngAbout', ngAbout);

  ngAbout.$inject = ['UrlService'];

  function ngAbout(UrlService) {
    return {
      restrict: 'E',
      templateUrl: UrlService.aboutTemplate()
    };
  }

})();
