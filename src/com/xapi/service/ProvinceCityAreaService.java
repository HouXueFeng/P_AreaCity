package com.xapi.service;

import java.util.List;

import com.xapi.dao.ProvinceCityAreaDao;
import com.xapi.dao.impl.ProvinceCityAreaDaoImp;
import com.xapi.po.Area;
import com.xapi.po.City;
import com.xapi.po.Province;

public class ProvinceCityAreaService {
	ProvinceCityAreaDao provinceCityAreaService = new ProvinceCityAreaDaoImp();
	public List<Province>findProvinceList() throws Exception{
		return provinceCityAreaService.findProvinceList();
	}
	
	//根据省份查询城市
	public	List<City>findCityByProvince(String province) throws Exception{
		return provinceCityAreaService.findCityByProvince(province);
	}
	
	//根据城市查询地域
	public List<Area>findAreaByCity(String city) throws Exception{
		return provinceCityAreaService.findAreaByCity(city);
		
	}
}
