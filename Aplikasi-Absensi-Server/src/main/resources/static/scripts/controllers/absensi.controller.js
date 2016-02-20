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

  AbsensiController.$inject = ['AbsensiService', 'AuthService'];

  function AbsensiController(AbsensiService, AuthService) {
    var absensi = this;

    absensi.paging = {
      page: 0,
      jumlah: 5
    };

    absensi.enableSearch = false;

    absensi.dataAbsensi = {};

    function getAllAbsensi() {
      absensi.enableSearch = false;
      AbsensiService.getAllAbsensiAsisten(absensi.paging.page, absensi.paging.jumlah).success(function(data) {
        absensi.dataAbsensi = data._embedded.absensi;
        absensi.paging.totalPages = data.page.totalPages;
      });
    }

    getAllAbsensi();

    absensi.getAllAbsensi = function() {
      absensi.enableSearch = false;
      absensi.paging.page = 0;
      absensi.paging.jumlah = 5;
      getAllAbsensi();
    };

    //paging all

    absensi.nextPage = function() {
      if (absensi.paging.page + 1 < absensi.paging.totalPages) {
        absensi.paging.page++;
        getAllAbsensi();
      }
    };

    absensi.hasNextPage = function() {
      if (absensi.paging.page + 1 < absensi.paging.totalPages) {
        return true;
      }
      return false;
    };

    absensi.previousPage = function() {
      if (absensi.paging.page > 0) {
        absensi.paging.page--;
        getAllAbsensi();
      }
    };

    absensi.hasPreviousPage = function() {
      if (absensi.paging.page > 0) {
        return true;
      }
      return false;
    };

    //end paging all

    absensi.npm = '';

    absensi.searchAbsensiAsistenByNpm = function(npm) {
      absensi.enableSearch = true;
      absensi.npm = npm;
      absensi.paging.page = 0;
      absensi.paging.jumlah = 5;
      AbsensiService.searchAbsensiAsistenByNpm(npm, absensi.paging.page, absensi.paging.jumlah).success(function(data) {
        if (angular.equals([], data._embedded.absensi)) {
          swal('Warning', 'maaf, data tidak ditemukan', 'error');
        } else {
          absensi.dataAbsensi = data._embedded.absensi;
          absensi.paging.totalPages = data.page.totalPages;
        }
      });
    };

    //paging search

    absensi.nextPageSearch = function() {
      if (absensi.paging.page + 1 < absensi.paging.totalPages) {
        absensi.paging.page++;
        absensi.searchAbsensiAsistenByNpm(absensi.npm);
      }
    };

    absensi.hasNextPageSearch = function() {
      if (absensi.paging.page + 1 < absensi.paging.totalPages) {
        return true;
      }
      return false;
    };

    absensi.previousPageSearch = function() {
      if (absensi.paging.page > 0) {
        absensi.paging.page--;
        absensi.searchAbsensiAsistenByNpm(absensi.npm);
      }
    };

    absensi.hasPreviousPageSearch = function() {
      if (absensi.paging.page > 0) {
        return true;
      }
      return false;
    };

    //end paging search

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

    absensi.logout = function() {
      AuthService.logout();
    };

  }

})();
