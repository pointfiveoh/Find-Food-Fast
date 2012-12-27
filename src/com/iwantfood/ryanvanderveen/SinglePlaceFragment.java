package com.iwantfood.ryanvanderveen;

import com.iwantfood.ryanvanderveen.Places.PlaceDetail;
import com.iwantfood.ryanvanderveen.SinglePlaceActivity.LoadSinglePlaceDetails;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SinglePlaceFragment extends Fragment {
    
    Boolean 			isInternetPresent 	= false; 		// flag for Internet connection status   
    ConnectionDetector 	cd; 								// Connection detector class    
    AlertDialogManager 	alert = new AlertDialogManager(); 	// Alert Dialog Manager   
    GooglePlaces 		googlePlaces; 						// Google Places    
    PlaceDetail 		placeDetail; 						// Place Details    
    ProgressDialog 		pDialog; 							// Progress dialog
    // KEY Strings
    public static String KEY_REFERENCE = "reference"; // id of the place
 
    @Override
	public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.singleplace);
 
        Intent i = getActivity().getIntent();
 
        // Place referece id
        String reference = i.getStringExtra(KEY_REFERENCE);
 
        // Calling a Async Background thread
        new LoadSinglePlaceDetails().execute(reference);
    }
 
    public void goToMapsClick(View v) {
    	switch(v.getId()) {
    	case R.id.findPlaceGoogleMapsButton:
    		goToGoogleMaps();
    		break;
    	default:
    		Log.wtf("WTFWTFWTF", "This should never occur SinglePlaceActivity.goToGoogleMaps");
    		break;
    	}
    }
    
    public void goToGoogleMaps() {
    	Uri uri = Uri.parse("geo:" 
    			+ Double.toString(placeDetail.result.geometry.location.lat) 
    			+ ","
    			+ Double.toString(placeDetail.result.geometry.location.lng));
    	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    	
    	startActivity(intent);
    }
    
    /**
     * Background Async Task to Load Google places
     * */
    class LoadSinglePlaceDetails extends AsyncTask<String, String, String> {
 
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SinglePlaceFragment.this.getActivity());
            pDialog.setMessage("Loading profile ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }
 
        /**
         * getting Profile JSON
         * */
        protected String doInBackground(String... args) {
            String reference = args[0];
 
            // creating Places class object
            googlePlaces = new GooglePlaces();
 
            // Check if used is connected to Internet
            try {
            	placeDetail = googlePlaces.getPlaceDetails(reference);
 
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed Places into LISTVIEW
                     * */
                    if(placeDetail != null){
                        String status = placeDetail.status;
 
                        // check place deatils status
                        // Check for all possible status
                        if(status.equals("OK")){
                            if (placeDetail.result != null) {
                                String name 		= placeDetail.result.name;
                                String address 		= placeDetail.result.formatted_address;
                                String phone 		= placeDetail.result.formatted_phone_number;
                                String latitude 	= Double.toString(placeDetail.result.geometry.location.lat);
                                String longitude 	= Double.toString(placeDetail.result.geometry.location.lng);
 
                                Log.d("Place ", name + address + phone + latitude + longitude);
 
                                // Displaying all the details in the view
                                // single_place.xml
                                TextView lbl_name 		= (TextView) getActivity().findViewById(R.id.name);
                                TextView lbl_address 	= (TextView) getActivity().findViewById(R.id.address);
                                TextView lbl_phone 		= (TextView) getActivity().findViewById(R.id.phone);
                                TextView lbl_location 	= (TextView) getActivity().findViewById(R.id.location);
 
                                // Check for null data from google
                                // Sometimes place details might missing
                                name 		= name == null ? "Not present" : name; // if name is null display as "Not present"
                                address 	= address == null ? "Not present" : address;
                                phone 		= phone == null ? "Not present" : phone;
                                latitude 	= latitude == null ? "Not present" : latitude;
                                longitude 	= longitude == null ? "Not present" : longitude;
 
                                lbl_name.setText(name);
                                lbl_address.setText(address);
                                lbl_phone.setText(Html.fromHtml("<b>Phone:</b> " + phone));
                                lbl_location.setText(Html.fromHtml("<b>Latitude:</b> " + latitude + ", <b>Longitude:</b> " + longitude));
                            }
                        }
                        else if(status.equals("ZERO_RESULTS")){
                            alert.showAlertDialog(SinglePlaceFragment.this.getActivity(), "Near Places",
                                    "Sorry no place found.",
                                    false);
                        }
                        else if(status.equals("UNKNOWN_ERROR"))
                        {
                            alert.showAlertDialog(SinglePlaceFragment.this.getActivity(), "Places Error",
                                    "Sorry unknown error occured.",
                                    false);
                        }
                        else if(status.equals("OVER_QUERY_LIMIT"))
                        {
                            alert.showAlertDialog(SinglePlaceFragment.this.getActivity(), "Places Error",
                                    "Sorry query limit to google places is reached",
                                    false);
                        }
                        else if(status.equals("REQUEST_DENIED"))
                        {
                            alert.showAlertDialog(SinglePlaceFragment.this.getActivity(), "Places Error",
                                    "Sorry error occured. Request is denied",
                                    false);
                        }
                        else if(status.equals("INVALID_REQUEST"))
                        {
                            alert.showAlertDialog(SinglePlaceFragment.this.getActivity(), "Places Error",
                                    "Sorry error occured. Invalid Request",
                                    false);
                        }
                        else
                        {
                            alert.showAlertDialog(SinglePlaceFragment.this.getActivity(), "Places Error",
                                    "Sorry error occured.",
                                    false);
                        }
                    }else{
                        alert.showAlertDialog(SinglePlaceFragment.this.getActivity(), "Places Error",
                                "Sorry error occured.",
                                false);
                    }
                }
            });
        }
    }
}
