package com.gtu.project.quickpay;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;



@Path("demo")
public class Demo {
	@GET	
	public Response demoMethod(){
		return Response.status(200)
    			.entity("AcNo:")
    			.build();
	}
	
}
