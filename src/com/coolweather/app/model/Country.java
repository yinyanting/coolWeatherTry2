package com.coolweather.app.model;

public class Country {
	
	private int id;
	private int cityId;
	private String countryName;
	private String countryCode;
	
	public int getId(){
		return id;
	}
	
	public int getcityId(){
		return cityId;
	}
	
	public String getcountryName(){
		return countryName;
	}
	
	public String getcountryCode(){
		return countryCode;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setcityId(int cityId){
		this.cityId=cityId;
	}
	
	public void setcountryName(String countryName){
		this.countryName=countryName;
	}
	
	public void setcountryCode(String countryCode){
		this.countryCode=countryCode;
	}

}
