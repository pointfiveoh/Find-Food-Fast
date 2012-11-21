package com.iwantfood.ryanvanderveen;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class OnlineSensor {
	
	private Context context;
	
	public OnlineSensor(Context _context) {
		context = _context;
	}
	
	/**
	 * Check if the phone is connected to the internet
	 */
	public boolean isOnline() {
		boolean returnValue = false;
		ConnectivityManager cm = (ConnectivityManager) 
				context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if(cm != null) {
			NetworkInfo[] info = cm.getAllNetworkInfo();
			for (NetworkInfo ni : info) {
				if(ni.getState() == NetworkInfo.State.CONNECTED) {
					returnValue = true;
				}
			}
		}
		return returnValue;
	}
}
