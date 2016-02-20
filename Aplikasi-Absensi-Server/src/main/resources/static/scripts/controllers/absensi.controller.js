/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:33:02 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

(function() {
  'use strict';
  angular.module('Aplikasi-Absensi')
    .controller('AbsensiController', AbsensiController);

  AbsensiController.$inject = ['AbsensiService'];

  function AbsensiController(AbsensiService) {
    var absensi = this;

    absensi.paging = {
      page: 0,
      jumlah: 5
    };

    absensi.dataAbsensi = {};

    function getAllAbsensi() {
      AbsensiService.getAllAbsensiAsisten(absensi.paging.page, absensi.paging.jumlah).success(function(data) {
        absensi.dataAbsensi = data._embedded.absensi;
        absensi.paging.totalPages = data.page.totalPages;
      });
    }

    getAllAbsensi();

    absensi.nextPage = function() {
      if (absensi.paging.page < absensi.paging.totalPages) {
        absensi.paging.page++;
        getAllAbsensi()();
      }
    };

    absensi.hasNextPage = function() {
      if (absensi.paging.page < absensi.paging.totalPages) {
        return false;
      }
      return true;
    };

    absensi.previousPage = function() {
      if (absensi.paging.page > 1) {
        absensi.paging.page--;
        getAllAbsensi()();
      }
    };

    absensi.hasPreviousPage = function() {
      if (absensi.paging.page > 1) {
        return false;
      }
      return true;
    };

    absensi.cetakLaporan = function() {
      $('#modalLaporan').openModal();
    };

    absensi.cetakLaporanBerdasarkan = function(enable, enableNpm, npm, tanggalAwal, tanggalAkhir) {
      if (enable) {
        window.open('/LaporanAbsensiAsisten', '_blank');
      } else if (enableNpm) {
        window.open('/LaporanAbsensiAsistenPerTanggalDanNpmAsisten?npm=' + npm + '&tanggalAwal=' + tanggalAwal + '&tanggalAkhir=' + tanggalAkhir, '_blank');
      } else {
        window.open('/LaporanAbsensiAsistenPerTanggal?tanggalAwal=' + tanggalAwal + '&tanggalAkhir=' + tanggalAkhir, '_blank');
      }
    };

  }

})();
