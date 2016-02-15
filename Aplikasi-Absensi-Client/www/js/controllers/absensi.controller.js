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
  .controller('AbsensiController', ['$scope', '$cordovaBarcodeScanner', function($scope, $cordovaBarcodeScanner) {

    $scope.hasilScan = '';

    $scope.scanBarcode = function() {
      $cordovaBarcodeScanner
        .scan()
        .then(function(barcodeData) {
          $scope.hasilScan = barcodeData.text;
        }, function(error) {});
    };

  }]);
