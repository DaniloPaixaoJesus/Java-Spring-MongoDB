package com.monzware.os.test;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless(mappedName = "Test")
@PermitAll
@WebService(serviceName = "Test", targetNamespace = "http://test.com", name = "TestService", portName = "TestPort")
public class OSTestServiceWS {

	@WebMethod
	public String noget(String str) {
		return "test1test";  
	}
 
}
