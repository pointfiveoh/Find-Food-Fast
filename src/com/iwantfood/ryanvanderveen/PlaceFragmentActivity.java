package com.iwantfood.ryanvanderveen;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class PlaceFragmentActivity extends FragmentActivity {

	DialogFragment af;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.placelistview);
		//check connection. If none exists, prompt the user to turn on
		
		isConnected();
		

	}
	
	private boolean isConnected() {
		boolean isConnected = false;
		ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
		
		isConnected = cd.isConnectingToInternet();
		if (!isConnected) {
			
			af = new AlertFragment();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
			if (prev != null) {
				ft.remove(prev);
			}
			ft.addToBackStack(null);
						
		}
			
		return false;
	}
}
