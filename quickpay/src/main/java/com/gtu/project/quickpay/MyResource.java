package com.gtu.project.quickpay;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gtu.project.quickpay.services.AccountService;
import com.gtu.project.quickpay.services.CustomerService;
import com.gtu.project.quickpay.services.UserService;
import com.gtu.project.quickpay.models.Account;
import com.gtu.project.quickpay.models.Customer;
import com.gtu.project.quickpay.models.User;

@Path("myresource")
public class MyResource {
	
	//get all accounts
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAllAccounts() {
        return AccountService.getAllAccounts();
    }
    
    @Path("createAccount")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account createAccount(Account acc){
    	Account account =  AccountService.createAccount(acc.getBalance(),acc.getPin(),acc.getCardId());
    	return account;
    }
    
    
    @Path("createCustomer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer createCustomer(Customer cus){
    	Customer customer =  CustomerService.createCustomer(cus.getFirstName(),cus.getMiddleName(),
    			cus.getLastName(),cus.getGender(),cus.getAddress(),cus.getPincode(),cus.getPhone(),
    			cus.getEmail(),cus.getAccountId());
    	return customer;
    }
    
    @Path("createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User us){
    	User user =  UserService.createUser(us.getCustomerId(),us.getPassword());
    	return user;
    }
}
