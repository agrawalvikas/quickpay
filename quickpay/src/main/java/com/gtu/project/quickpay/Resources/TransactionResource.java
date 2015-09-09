package com.gtu.project.quickpay.Resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.gtu.project.quickpay.models.Transaction;
import com.gtu.project.quickpay.services.TransactionService;

@Path("transactionresource")
//This class would have Varify Card (GET) and transfer amount(PUT)
public class TransactionResource {

	
	@GET
	@Path("{AcNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getTransactions(@PathParam("AcNo") long AcNo){
		return TransactionService.getTransactions(AcNo);
	}
	
	
	@Path("card/{cardID}")
	@GET
	public Response varifyCard(@PathParam("cardID") String cardID){
		long acNo;
		Response response;
		acNo = TransactionService.varifyCard(cardID);
		System.out.println("REsource call and got acNo:"+acNo);
		if(acNo == 0){
			response = Response.status(Status.NOT_FOUND).entity(acNo).build();
	
		}else{
			response = Response.status(Status.OK).entity(acNo).build();
		}
		return response;
	}
	
	
	@Path("{fromAc}/{toAc}/{amt}/{pin}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction transferAmount(@PathParam("fromAc") long fromAc,@PathParam("toAc") long toAc,
			@PathParam("amt") int amt,@PathParam("pin") int pin)
	{
		return TransactionService.transferAmount(fromAc,toAc,amt,pin);
	}
}
