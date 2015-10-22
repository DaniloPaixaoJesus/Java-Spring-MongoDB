package com.monzware.os.test;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/test")
@Consumes({ "application/json; charset=UTF-8" })
@Produces({ "application/json; charset=UTF-8" })
public class OSTestService {

	@Context
	private HttpServletRequest inRequest;

	@GET
	@Path("/do")
	public String test() {

		String ipAddress = inRequest.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = inRequest.getRemoteAddr();
		}
		System.out.println("ipAddress:" + ipAddress);

		return ipAddress;
	}
}