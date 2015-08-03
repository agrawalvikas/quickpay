<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<h1 style="font-size:40px"class ="fs-title">welcome to quickpay</h1>

	<form action ="" method= "post" name= "testform" id="testform">
		<fieldset>
			<h2 class="fs-title">Login</h2>
			<input  class ="login" placeholder="Username" type="text" id="username" name="username" />
			<input class ="login"  placeholder="Password" type="text" id="loginpassword" name="loginpassword" />
			<input  type ="submit" id="login" value="login" class ="adduserbutton"></input>
		</fieldset>
	</form>
	
	<form action ="" method= "post" name= "testform" id="testform" novalidate="novalidate">
		<fieldset>
		<h2 class="fs-title">Create your account</h2>
	    <input  placeholder="Firstname" type="text" id="firstName" name="firstName" />
	    <input  placeholder="MiddleName" type="text" id="middleName" name="middleName" />
	    <input  placeholder="LastName" type="text" id="lastName" name="lastName" /><br>
	    <label style="margin-right: 40px;" for="male">
	    <input type="radio" name="gender" id="male" value="male">Male</label>
    	<label for="female">
    	<input type="radio" name="gender" id="female" value="female">Female</label>
		<br>	    
	    <input  placeholder="Address"  type="text" id="address" name="address" />
	    <input  placeholder="Pincode"  type="text" id="pincode" name="pincode" />
	    <input  placeholder="Phone" type="text" id="phone" name="phone" />
	    <input  placeholder="Email" type="text" id="email" name="email" />
	    <input  placeholder="Password" type="text" id="password" name="password" />
	    <input  placeholder="Confirm Password" type="text" id="cpassword" name="cpassword" />
		<input  placeholder="Balance" type="text" id="balance" name="balance" />
		<input  placeholder="CardId"   type="text"  id="cardId" name="cardId" />
		<input  placeholder="PIN"   type="text"  id="pin" name="pin" /><br>
		<input  type ="submit" id="add-account" value="Register" class ="adduserbutton"></input>
		</fieldset>
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
</body>
</html>