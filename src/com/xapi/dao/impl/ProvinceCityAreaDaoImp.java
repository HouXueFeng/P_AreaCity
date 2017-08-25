package com.xapi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xapi.dao.ProvinceCityAreaDao;
import com.xapi.db.JdbcUtils;
import com.xapi.po.Area;
import com.xapi.po.City;
import com.xapi.po.Province;

public class ProvinceCityAreaDaoImp implements ProvinceCityAreaDao {
	/**
	 * 根据省份查询城市
	 */
	@Override
	public List<City> findCityByProvince(String province) throws Exception {
		List<City> cities = new ArrayList<>();
		Connection con = JdbcUtils.getConnection();
		PreparedStatement pre = con.prepareStatement("select * from city where provincecode=?");
		pre.setString(1, province);
		ResultSet set = pre.executeQuery();
		while (set.next()) {
			City city = new City();
			city.setCode(set.getString("code"));
			city.setId(set.getInt("id"));
			city.setName(set.getString("name"));
			city.setProvinceCode(set.getString("provincecode"));
			cities.add(city);
		}
		return cities;
	}

	/**
	 * 根据城市查询地区
	 */
	@Override
	public List<Area> findAreaByCity(String city) throws Exception {
		List<Area> areas = new ArrayList<>();
		Connection con = JdbcUtils.getConnection();
		PreparedStatement pre = con.prepareStatement("select * from area where citycode=?");
		pre.setString(1, city);
		ResultSet set = pre.executeQuery();
		while (set.next()) {
			Area area = new Area();
			area.setCitycode(set.getString("citycode"));
			area.setId(set.getInt("id"));
			area.setName(set.getString("name"));
			area.setCode(set.getString("code"));
			areas.add(area);
		}
		return areas;
	}

	@Override
	public List<Province> findProvinceList() throws Exception {
		List<Province> provinces = new ArrayList<>();
		Connection con = JdbcUtils.getConnection();
		PreparedStatement sta = con.prepareStatement("select * from province");
		ResultSet set = sta.executeQuery();
		while (set.next()) {
			Province province = new Province();
			province.setId(set.getInt("id"));
			province.setName(set.getString("name"));
			province.setCode(set.getString("code"));
			provinces.add(province);
		}
		return provinces;
	}
}
