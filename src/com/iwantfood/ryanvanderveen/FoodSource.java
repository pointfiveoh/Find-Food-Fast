package com.iwantfood.ryanvanderveen;

public class FoodSource {
	public String address;
	public String name;
	public String relevance;
	public String rating;
	public String type;
	public String distance;
	public String cost;
	
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelevance() {
		return relevance;
	}
	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "FoodSource [address=" + address + ", name=" + name
				+ ", relevance=" + relevance + ", rating=" + rating + ", type="
				+ type + ", distance=" + distance + "]";
	}
	
	
}
