package com.coolweather.app.db;

import java.util.ArrayList;
import java.util.List;

import com.coolweather.app.model.City;
import com.coolweather.app.model.Country;
import com.coolweather.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class CoolWeatherDB {
	
	public static final String DB_NAME="cool_weather";
	public static final int VERSION=1;
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;
	
	private CoolWeatherDB(Context context){
		CoolWeatherOpenHelper dbHelper=new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
		db=dbHelper.getWritableDatabase();
	}
	
	public synchronized static CoolWeatherDB getInstance(Context context){
		if(coolWeatherDB==null){
			coolWeatherDB=new CoolWeatherDB(context);
			
		}
		return coolWeatherDB;
	}
	
	public void saveProvince(Province province){
		if(province!=null){
			ContentValues values=new ContentValues();
			values.put("province_name", province.getprovinceName());
			values.put("province_code", province.getprovinceCode());
			db.insert("Province", null, values);
		}
	}
	
	//从数据库读取全国所有的省份信息
	public List<Province>loadProvince(){
		List<Province>list=new ArrayList<Province>();
		Cursor cursor=db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Province province=new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
				
				list.add(province);
			}while(cursor.moveToNext());
		}
		return list;
	}
	
	//将City实例存储到数据库
	public void saveCity(City city){
		if(city!=null){
			ContentValues values=new ContentValues();
			values.put("city_name", city.getcityName());
			values.put("city_code", city.getcityCode());
			values.put("province_id", city.getprovinceId());
			db.insert("City", null, values);
		}
	}
	
	public List<City>loadCities(int provinceId){
		List<City>list=new ArrayList<City>();
		Cursor cursor=db.query("City", null, "province_id=?", new String[]{String.valueOf(provinceId)}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				City city=new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setcityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setcityName(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setprovinceId(provinceId);
				list.add(city);
			}while(cursor.moveToNext());
		}
		return list;
	}
	
	public void saveCountry(Country country){
		if(country!=null){
			ContentValues values=new ContentValues();
			values.put("country_name", country.getcountryName());
			values.put("country_code", country.getcountryCode());
			values.put("city_id", country.getcityId());
			db.insert("Country", null, values);
		}
	}
	
	public List<Country>loadCountries(int cityId){
		List<Country>list=new ArrayList<Country>();
		Cursor cursor=db.query("Country", null, "city_id=?", new String[]{String.valueOf(cityId)}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Country country=new Country();
				country.setId(cursor.getInt(cursor.getColumnIndex("id")));
				country.setcountryCode(cursor.getString(cursor.getColumnIndex("country_code")));
				country.setcountryName(cursor.getString(cursor.getColumnIndex("country_name")));
				country.setcityId(cityId);
				list.add(country);
			}while(cursor.moveToNext());
		}
		return list;
	}

}
