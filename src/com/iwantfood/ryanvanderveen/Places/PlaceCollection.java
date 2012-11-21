package com.iwantfood.ryanvanderveen.Places;

import java.io.Serializable;
import java.util.List;
 
import com.google.api.client.util.Key;

public class PlaceCollection {
	
	@Key
	public String status;
	 
	@Key
	public List<Place> results;
	 
}
