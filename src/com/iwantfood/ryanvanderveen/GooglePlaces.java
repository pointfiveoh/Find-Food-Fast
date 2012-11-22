package com.iwantfood.ryanvanderveen;

import org.apache.http.client.HttpResponseException;

import android.util.Log;
 
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson.JacksonFactory;
//import org.codehaus.jackson.JsonFactory;

import com.iwantfood.ryanvanderveen.Places.*;
 
@SuppressWarnings("deprecation")
public class GooglePlaces {
 
    /** Global instance of the HTTP transport. */
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
 
    // Google API Key
    private static final String API_KEY = "AIzaSyBp_ZBg-43O_sZymW82se72zt20KDEQKF4";
 
    // Google Places serach url's
    private static final String PLACES_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
    private static final String PLACES_TEXT_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
    private static final String PLACES_DETAILS_URL = "https://maps.googleapis.com/maps/api/place/details/json?";
 
    private double _latitude;
    private double _longitude;
    private double _radius;
 
    /**
     * Searching places
     * @param latitude - latitude of place
     * @params longitude - longitude of place
     * @param radius - radius of searchable area
     * @param types - type of place to search
     * @return list of places
     * */
    public PlaceCollection search(double latitude, double longitude, double radius, String types)
            throws Exception {
 
        this._latitude = latitude;
        this._longitude = longitude;
        this._radius = radius;
 
        try {
 
            HttpRequestFactory httpRequestFactory = createRequestFactory(HTTP_TRANSPORT);
            HttpRequest request = httpRequestFactory
                    .buildGetRequest(new GenericUrl(PLACES_SEARCH_URL));
            request.getUrl().put("key", API_KEY);
            request.getUrl().put("location", _latitude + "," + _longitude);
            request.getUrl().put("radius", _radius); // in meters
            request.getUrl().put("sensor", "false");
            if(types != null)
                request.getUrl().put("types", types);
 
            PlaceCollection list = request.execute().parseAs(PlaceCollection.class);
            // Check log cat for places response status
            Log.d("Places Status", "" + list.status);
            return list;
 
        } catch (HttpResponseException e) {
            Log.e("Error:", e.getMessage());
            return null;
        }
 
    }
 
    /**
     * Searching single place full details
     * @param refrence - reference id of place
     *                 - which you will get in search api request
     * */
    public PlaceDetail getPlaceDetails(String reference) throws Exception {
        try {
 
            HttpRequestFactory httpRequestFactory = createRequestFactory(HTTP_TRANSPORT);
            HttpRequest request = httpRequestFactory
                    .buildGetRequest(new GenericUrl(PLACES_DETAILS_URL));
            request.getUrl().put("key", API_KEY);
            request.getUrl().put("reference", reference);
            request.getUrl().put("sensor", "false");
 
            PlaceDetail place = request.execute().parseAs(PlaceDetail.class);
 
            return place;
 
        } catch (HttpResponseException e) {
            Log.e("Error in Perform Details", e.getMessage());
            throw e;
        }
    }
 
    /**
     * Creating http request Factory - THIS METHOD IS DEPRECATED.
     * */
    /*public static HttpRequestFactory createRequestFactory(
            final HttpTransport transport) {
        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
                GoogleHeaders headers = new GoogleHeaders();
                headers.setApplicationName("AndroidHive-Places-Test");
                request.setHeaders(headers);
                JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
                request.addParser(parser);
            }
        });
    }*/
    
    public static HttpRequestFactory createRequestFactory(
    		final HttpTransport transport) {
    	return transport.createRequestFactory(new HttpRequestInitializer() {
    		public void initialize(HttpRequest request) {
    			GoogleHeaders headers = new GoogleHeaders();
                headers.setApplicationName("Find-Food-Fast");
                request.setHeaders(headers);
                //JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
                JsonObjectParser parser = new JsonObjectParser(new AndroidJsonFactory());
                request.setParser(parser);
    		}
    	});
    }
}