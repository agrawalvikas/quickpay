package com.gtu.project.quickpay.Resources;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gtu.project.quickpay.models.LoggedUser;
import com.gtu.project.quickpay.services.UserService;

@Path("loginresource")
public class LoginResource {

	@Path("{username}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public long loginUser(@PathParam("username") int userId,@PathParam("password") String password){
		return UserService.loginUser(userId,password);
	}
	@GET
	public String getIt(){
		return "Hello you got it";
	}
	
	@Path("{custID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public LoggedUser getLoggedUser(@PathParam("custID") long custID){
		return UserService.getDetails(custID);
	}
}