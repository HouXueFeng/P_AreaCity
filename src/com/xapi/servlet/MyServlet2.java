package com.xapi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.xapi.po.City;
import com.xapi.service.ProvinceCityAreaService;

@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 根据省获取市
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		ProvinceCityAreaService service = new ProvinceCityAreaService();
		String code = request.getParameter("code");
		System.out.println(code);
		try {
			List<City> findCityByProvince = service.findCityByProvince(code);
			String jsonString = JSON.toJSONString(findCityByProvince);
			response.getWriter().println(jsonString);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
