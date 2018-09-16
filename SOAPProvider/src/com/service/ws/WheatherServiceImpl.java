package com.service.ws;

import javax.jws.WebService;

import com.service.vo.WheatherVO;

@WebService(endpointInterface = "com.service.ws.WheatherService")
public class WheatherServiceImpl {

	public String getWheather(String str) {
		if ("Pune".equalsIgnoreCase(str)) {
			return "28";
		} else if ("Mumbai".equalsIgnoreCase(str)) {
			return "30";
		}
		return "50";
	}

	public String getWheather2(WheatherVO str) {
		if ("Pune".equalsIgnoreCase("")) {
			return "28";
		} else if ("Mumbai".equalsIgnoreCase("")) {
			return "30";
		}
		return "50";
	}

}
