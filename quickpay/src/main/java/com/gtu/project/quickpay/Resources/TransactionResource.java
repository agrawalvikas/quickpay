package com.gtu.project.quickpay.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gtu.project.quickpay.models.Transaction;
import com.gtu.project.quickpay.services.TransactionService;

@Path("transactionresource")
//This class would have Varify Card (GET) and transfer amount(PUT)
public class TransactionResource {

	@Path("{cardID}")
	@GET
	public long varifyCard(@PathParam("cardID") String cardID){
		return TransactionService.varifyCard(cardID);
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
