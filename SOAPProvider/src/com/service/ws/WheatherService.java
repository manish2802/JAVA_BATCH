package com.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.service.vo.WheatherVO;

@WebService(serviceName="manish")
public interface WheatherService {

	@WebMethod(operationName = "getWheather")
	public String getWheather(String str);

	@WebMethod(operationName = "getWheather2")
	public String getWheather2(WheatherVO str);

}
