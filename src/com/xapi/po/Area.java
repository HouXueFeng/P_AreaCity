package com.xapi.po;

public class Area {

	private String code;// 区编号
	private Integer id;//主键id号
	private String name;//地区名
	private String citycode;//所属城市编号
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	@Override
	public String toString() {
		return "Area [code=" + code + ", id=" + id + ", name=" + name + ", citycode=" + citycode + "]";
	}
	
}	
