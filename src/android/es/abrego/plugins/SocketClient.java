package es.abrego.plugins;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Stack;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Gravity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
public class SocketClient extends CordovaPlugin {

	private static final String ACTION_SEND_SOCKET = "sendSocket";
   
	public boolean sendSocket(String dstAddress, int dstPort, String message,  CallbackContext callbackContext){
	  String response = "";
	  Socket socket = null;
	  try{
		  socket = new Socket(dstAddress, dstPort);
		  //send message
		  DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
		  dOut.writeByte(1);
		  dOut.writeUTF(message);
		  dOut.flush();
		  
		  //read message
		  ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
		  byte[] buffer = new byte[1024];			
		  int bytesRead;			
		  InputStream inputStream = socket.getInputStream();			
		  /*
		   * notice:
		   * inputStream.read() will block if no data return
		   */
		  while ((bytesRead = inputStream.read(buffer)) != -1){
			  byteArrayOutputStream.write(buffer, 0, bytesRead);
			  response += byteArrayOutputStream.toString("UTF-8");
		  }	            
	  }catch (UnknownHostException e) {	            	   
				e.printStackTrace();
				response = "UnknownHostException: " + e.toString();
				callbackContext.error(response);
	   } catch (IOException e) {	            	   
				e.printStackTrace();
				response = "IOException: " + e.toString();
				callbackContext.error(response);
	   }finally{
			if(socket != null){
				 try {
				  socket.close();
				 } catch (IOException e) {	            	    
				  e.printStackTrace();
				 }
			}
	   }
					   
	  callbackContext.success(response);
	  return false;
	} 

	  
  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		  
	  
	  
	  if(ACTION_SEND_SOCKET.equals(action)){
		  /*
		   * <uses-permission android:name="android.permission.INTERNET" >
			</uses-permission>
			
			<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" >
			</uses-permission>
		   * */
		  final String address = args.getString(0);
		  final String port= args.getString(1);
		  final String message= args.getString(2);
		  new Thread(new Runnable() {
			    public void run() {
			    	int int_port =  Integer.parseInt(port);
			    	sendSocket(address,int_port, message, callbackContext);
			    }
			}).start();		  		 
		  return true;
	  } else {
	      callbackContext.error("SocketClient." + action + " is not a supported function. Did you mean '" + ACTION_SEND_SOCKET + "'?");
	      return false;
	  }
  }
  
  
  
}