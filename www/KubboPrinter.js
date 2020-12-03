var exec = require('cordova/exec');

var KPrinter = {
    print: function (fnSuccess, fnError, pdfFileBase64, ipPrinter, portPrinter) {
        exec(fnSuccess, fnError, "KubboPrinter", "print", [pdfFileBase64, ipPrinter, portPrinter]);
    },
    disconnect: function (fnSuccess, fnError) {
        exec(fnSuccess, fnError, "KubboPrinter", "disconnect", []);
    }
};

module.exports = KPrinter;
