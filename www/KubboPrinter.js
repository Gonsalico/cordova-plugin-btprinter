var exec = require('cordova/exec');

var KPrinter = {
    printTest: function (fnSuccess, fnError, pdfFileBase64) {
        exec(fnSuccess, fnError, "KubboPrinter", "printTest", [pdfFileBase64]);
    }
    // print: function (fnSuccess, fnError, ip, port, base64Text) {
    //     exec(fnSuccess, fnError, "BluetoothPrinter", "connect", [ip, port, base64Text]);
    // }
};

module.exports = KPrinter;
