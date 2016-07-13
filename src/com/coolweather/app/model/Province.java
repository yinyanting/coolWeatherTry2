package com.coolweather.app.model;

public class Province {
	
	private int id;
	private String provinceName;
	private String provinceCode;
	
	public int getId(){
		return id;
	}
	
	public String getprovinceName(){
		return provinceName;
	}
	
	public String getprovinceCode(){
		return provinceCode;
	}

	public void setProvinceName(String provinceName){
		this.provinceName=provinceName;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setProvinceCode(String provinceCode){
		this.provinceCode=provinceCode;
	}
}
