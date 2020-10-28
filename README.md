# Cordova-Plugin-Kubbo-Printer

A cordova plugin for print through socket base64code

Suggestions, critiques are welcome, participate and send a commit helping to improve the plugin for the community.

Thank's!

## Support

- [ Print Base64](#Print-base64)

## Install

Using the Cordova CLI and NPM, run:

```
cordova plugin add https://github.com/Gonsalico/cordova-plugin-kubbo-printer.git
```

## Print Base64

Print any base64code, in our case we printed parsed Base64 to ZPL and you can still print it.

```
KPrinter.print(function(data){
    console.log("Printed");
    resolve(data);
},function(err){
    console.log(err);
    reject(err)
}, pdfBase64String)
```

Return:

```
"Printed Succesfully"
```