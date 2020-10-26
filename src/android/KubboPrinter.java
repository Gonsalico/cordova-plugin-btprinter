package br.com.cordova.printer.kubbo;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;


public class KubboPrinter extends CordovaPlugin{

    private static final String LOG_TAG = "KubboPrinter";
    private Socket clientSocket = null;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("printTest")) {
            String pdfFileBase64 = args.getString(0);
            print(callbackContext, pdfFileBase64);
            return true;
        }
    }
    
    void print(CallbackContext callbackContext, String pdfFileBase64) {
        try {
            Log.d(LOG_TAG, "STARTING PRINT");
            // The line below illustrates the default port 6101 for mobile printers 9100 is the default port number
            // for desktop and tabletop printers
            DataOutputStream outToServer = new DataOutputStream(getSocket().getOutputStream() );
            //The data being sent in the lines below illustrate CPCL  one can change the data for the corresponding
            //language being used (ZPL, EPL)
            outToServer.writeBytes(pdfFileBase64);
            Log.d(LOG_TAG, "PROCESS FINISHED");
            callbackContext.success("Se ha Imprimido correctamente");
        } catch (Exception ex) {
            String errMsg = ex.getMessage();
            Log.e(LOG_TAG, errMsg);
            callbackContext.error(errMsg);
        }
    }

    Socket getSocket() {

        try {
            if(Objects.isNull(this.clientSocket)) {
                this.clientSocket = new Socket("192.168.000.100",9100);
            }
            if(this.clientSocket.isConnected()){
                return this.clientSocket;
            }
        } catch (Exception ex) {
            String errMsg = ex.getMessage();
            Log.e(LOG_TAG, errMsg);
            callbackContext.error(errMsg);
        }
    }
}
