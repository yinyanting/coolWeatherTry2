package com.coolweather.app.model;

public class City {
	
	private int id;
	private int provinceId;
	private String cityName;
	private String cityCode;
	
	public int getId(){
		return id;
	}
	
	public int getprovinceId(){
		return provinceId;
	}
	
	public String getcityName(){
		return cityName;
	}
	
	public String getcityCode(){
		return cityCode;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setprovinceId(int provinceId){
		this.provinceId=provinceId;
	}
	
	public void setcityName(String cityName){
		this.cityName=cityName;
	}
	
	public void setcityCode(String cityCode){
		this.cityCode=cityCode;
	}

}
