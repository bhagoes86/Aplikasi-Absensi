/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 9:55:04 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Client
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/javascript.js.
 *
 */

angular.module('Aplikasi-Absensi')
  .controller('AbsensiController', ['$scope', '$cordovaBarcodeScanner', 'AbsensiService', '$ionicModal', '$ionicPopup', function($scope, $cordovaBarcodeScanner, AbsensiService, $ionicModal, $ionicPopup) {

    $scope.hasilScan = '';
    $scope.modalInputDataAsisten = {};
    $scope.inputAbsensiAsisten = {};
    $scope.dataAbsensiAsisten = {};

    function inputDataAsisten() {
      $ionicModal.fromTemplateUrl('templates/inputDataAsisten.html', {
        scope: $scope
      }).then(function(modal) {
        $scope.modalInputDataAsisten = modal;
        $scope.modalInputDataAsisten.show();
      });
    }

    inputDataAsisten();

    $scope.simpanAbsensiAsisten = function(a) {
      var d = new Date();
      var hari = ["minggu", "senin", "selasa", "rabu", "kamis", "jumat", "sabtu"];

      $scope.dataAbsensiAsisten.namaAsistenTetap = a.namaAsistenTetap;
      $scope.dataAbsensiAsisten.barisJaga = a.barisJaga;
      $scope.dataAbsensiAsisten.mataPraktikum = a.mataPraktikum;
      $scope.dataAbsensiAsisten.kelasPraktikum = a.kelasPraktikum;
      $scope.dataAbsensiAsisten.ruangPraktikum = a.ruangPraktikum;
      $scope.dataAbsensiAsisten.sesiJaga = a.sesiJaga;
      $scope.dataAbsensiAsisten.hariJaga = hari[d.getDay()];
      $scope.dataAbsensiAsisten.tanggalJaga = d;

      $scope.modalInputDataAsisten.hide();
    };

    $scope.scanBarcode = function() {

      $cordovaBarcodeScanner
        .scan()
        .then(function(barcodeData) {

          $scope.hasilScan = barcodeData.text;

          AbsensiService.checkNpmAsisten(barcodeData.text).success(function(data) {

            $scope.dataAbsensiAsisten.npmAsisten = barcodeData.text;
            $scope.dataAbsensiAsisten.namaAsisten = data.nama;

            AbsensiService.simpanAbsensiAsisten($scope.dataAbsensiAsisten).success(function(data) {
              $ionicPopup.show({
                template: 'Berhasil melakukan absensi',
                title: 'Info',
                scope: $scope,
                buttons: [{
                  text: '<b>OK</b>',
                  type: 'button-positive'
                }]
              });
            }).error(function(data, status) {
              $ionicPopup.show({
                template: 'Maaf sedang terjadi kesalahan',
                title: 'Info',
                scope: $scope,
                buttons: [{
                  text: '<b>OK</b>',
                  type: 'button-positive'
                }]
              });
            });

          }).error(function(data, status) {
            $ionicPopup.show({
              template: 'Maaf Data asisten tidak ditemukan',
              title: 'Warning',
              scope: $scope,
              buttons: [{
                text: '<b>OK</b>',
                type: 'button-positive'
              }]
            });
          });

        }, function(error) {
          $ionicPopup.show({
            template: 'Maaf sedang terjadi kesalahan pada saat melakukan scan barcode',
            title: 'Info',
            scope: $scope,
            buttons: [{
              text: '<b>OK</b>',
              type: 'button-positive'
            }]
          });
        });

    };

  }]);
