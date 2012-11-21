package com.iwantfood.ryanvanderveen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;


public class FoodFinderActivity extends Activity {
	LocationManager 	locationManager;
	LocationProvider 	locationProvider;
	AlertFragment 		af;
	Context context 	= getApplicationContext();
	
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		instantiateLocationServices();
	}
	
	
	private void instantiateLocationServices() {
		//instantiate locationManager
		boolean success = false;
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		//instantiate locationProvider
		Criteria c = new Criteria();
		c.setAccuracy(Criteria.ACCURACY_FINE);
		c.setCostAllowed(true);
		String providerName = locationManager.getBestProvider(c, true);
		success = locationManager.isProviderEnabled(providerName);
		
		if (success) {
			locationProvider = locationManager.getProvider(providerName);
		}
		else
		{
			af = new AlertFragment();
		}
	}
	
}
