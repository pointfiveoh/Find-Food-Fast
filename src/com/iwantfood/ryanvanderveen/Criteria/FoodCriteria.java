package com.iwantfood.ryanvanderveen.Criteria;

import android.content.res.Resources;

/**
 * 
 * @author RVanderv
 * 
 * This is the parent class to the other classes 
 * in this folder (com.iwantfood.ryanvanderveen.criteria)
 */


public abstract class FoodCriteria {
	public static String type;
	final int NUM_CRITERIA = 3;
	final int NUM_CRITERIA_ONE_PERCENT = 4;
	protected String title;
	protected String header;

	protected Resources res;
	protected String criteria[] = new String[NUM_CRITERIA];
	
	public FoodCriteria(Resources _resources) {
		res = _resources;
	}
	
	public String[] getCriteria() {
		return criteria;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeader() {
		return header	;
	}
	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public String toString() {
		String ret;
		ret = getClass().getName() + "[" +
				"title=" + title + ", " + "\n" +
				"header=" + header + ", " + "\n";	
		
		for (String s : criteria) {
			ret += "criteria";
			ret += s;
			ret += "---";
		}
				
		ret += "]";
		
		return ret;
	}
	
}
