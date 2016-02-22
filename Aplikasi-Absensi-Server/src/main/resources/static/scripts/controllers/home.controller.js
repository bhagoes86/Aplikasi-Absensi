/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 20, 2016
 * @Time 7:39:58 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .controller('HomeController', HomeController);

  HomeController.$inject = ['AsistenService'];

  function HomeController(AsistenService) {
    var home = this;

    home.cetakKartu = function() {
      $('#modalKartu').openModal();
    };

    home.checkAsisten = function(npm) {
      AsistenService.getAsisten(npm).success(function(data) {
        window.open('/KartuAsisten?npm=' + npm, '_blank');
        $('#modalKartu').closeModal();
      }).error(function(data, status) {
        if (status === 404) {
          swal('Warning', 'anda belum melakukan registrasi, silahkan registrasi untuk mencetak kartu asisten', 'error');
        }
      });
    };

    home.close = function() {
      $('#modalKartu').closeModal();
    };

  }

})();
