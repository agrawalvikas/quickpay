$(function(){
	console.log("Jquery called");
	$('#add-account').click(function(event){
		event.preventDefault();
		var firstName = $("#firstName").val();
		var middleName = $("#middleName").val();
		var lastName = $("#lastName").val();
		var gender = $("input:radio[name=gender]").val();
		var address = $("#address").val();
		var pincode = $("#pincode").val();
		var phone = $("#phone").val();
		var email = $("#email").val();
		var password = $("#password").val();
		var balance = $("#balance").val();
		var pin = $("#pin").val();
		var cardId = $("#cardId").val();
		alert("Password:"+password);
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/quickpay/webapi/myresource/createAccount",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				"balance":balance,
				"pin": pin,
				"cardId": cardId
			}),	
			dataType: "json",
			success:function (successResponse,textStatus,jqXHR) {
				var accountId = successResponse.accountId ;
				$.ajax({
					type: "POST",
					url: "http://localhost:8081/quickpay/webapi/myresource/createCustomer",
					contentType: "application/json; charset=utf-8",
					data: JSON.stringify({
						"firstName":firstName,
						"middleName":middleName,
						"lastName":lastName,
						"gender":gender,
						"address":address,
						"pincode":pincode,
						"phone":phone,
						"email":email,
						"accountId":accountId
					}),	
					dataType: "json",
					success:function (successResponse1,textStatus,jqXHR) {
						var customerId = successResponse1.customerId;
						var gender = successResponse1.gender;
						$.ajax({
							type: "POST",
							url: "http://localhost:8081/quickpay/webapi/myresource/createUser",
							contentType: "application/json; charset=utf-8",
							data: JSON.stringify({
								"customerId":customerId,
								"password":password
							}),	
							dataType: "json",
							success:function (successResponse2,textStatus,jqXHR) {
								if(textStatus == "success"){
									alert("Registered:"+textStatus+"\n Use Following credentials to login:\n"
											+"Username:"+customerId+"Password:"+password+"\nGender is:"+gender);
								}
								else{
									alert("Status:"+textStatus);
								}
								
								location.reload();
							},
							error: function (errorResponse2) {
								console.log(errorResponse2);
								alert(errorResponse2);
							}
						});	
					},
					error: function (errorResponse1) {
						console.log(errorResponse1);
						alert(errorResponse1);
					}
				});	
			},
			error: function (errorResponse) {
				console.log(errorResponse);
				alert(errorResponse);
			}
		});
});
});
