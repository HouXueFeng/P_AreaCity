package com.xapi.dao;
import java.util.List;
import com.xapi.po.Area;
import com.xapi.po.City;
import com.xapi.po.Province;

public interface ProvinceCityAreaDao {
	//查询出省份
	List<Province>findProvinceList()throws Exception;
	
	//根据省份查询城市
	List<City>findCityByProvince(String province) throws Exception; 
	
	//根据城市查询地域
	List<Area>findAreaByCity(String city) throws Exception;
}
