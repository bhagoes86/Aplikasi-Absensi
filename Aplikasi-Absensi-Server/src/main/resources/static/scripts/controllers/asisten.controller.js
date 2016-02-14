/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:36:41 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .controller('AsistenController', AsistenController);

  AsistenController.$inject = ['AsistenService', '$state'];

  function AsistenController(AsistenService, $state) {
    var asisten = this;

    asisten.inputAsisten = {};

    asisten.registrasi = function(a) {
      AsistenService.registrasiAsisten(a).success(function(data) {
        swal('Info', 'anda berhasil melakukan registrasi, silahkan login :)', 'success');
        asisten.inputAsisten = {};
        $state.go('login');
      });
    };

  }

})();
