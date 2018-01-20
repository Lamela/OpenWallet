<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!--[if IE 6]>
<html id="ie6" dir="ltr" lang="en-US">
<![endif]-->
<!--[if IE 7]>
<html id="ie7" dir="ltr" lang="en-US">
<![endif]-->
<!--[if IE 8]>
<html id="ie8" dir="ltr" lang="en-US">
<![endif]-->
<!--[if !(IE 6) | !(IE 7) | !(IE 8)  ]><!-->
<html dir="ltr" lang="en-US">
<!--<![endif]-->
<head>

	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width" />

	<title>Open Wallet - Probably the best online shop</title>

	<!-- [favicon] begin -->
	<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
	<link rel="icon" type="image/x-icon" href="images/favicon.ico" />
	<!-- [favicon] end --> 

	<!-- CSS Main -->
	<link rel="stylesheet" type="text/css" media="all" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" media="all" href="style.css" />
	<link rel="stylesheet" type="text/css" media="screen and (max-width: 960px)" href="css/lessthen960.css" />
	<link rel="stylesheet" type="text/css" media="screen and (max-width: 600px)" href="css/lessthen600.css" />
	<link rel="stylesheet" type="text/css" media="screen and (max-width: 480px)" href="css/lessthen480.css" />
	<link rel="stylesheet" type="text/css" media="all" href="css/memento.css"  />

	<!-- CSS Plugin -->
	<link rel="stylesheet" href="css/prettyPhoto.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/tipsy.css" type="text/css" media="all" />
	<link rel='stylesheet' href='css/buttons.min.css' type='text/css' media='all' />
	<link rel='stylesheet' href='css/labels.min.css' type='text/css' media='all' />
	<link rel='stylesheet' href='css/wells.min.css' type='text/css' media='all' />

	<!-- CSS Slider -->
	<link rel="stylesheet" href="css/slider-thumbnails.css" type="text/css" media="all" />

	<link rel="stylesheet" type="text/css" media="all" href="css/homes/home.css" />


	<!-- FONTS -->
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Droid+Sans&amp;subset=latin%2Ccyrillic%2Cgreek&amp;ver=3.4.1" type="text/css" media="all" />
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Shadows+Into+Light&amp;subset=latin%2Ccyrillic%2Cgreek&amp;ver=3.4.1" type="text/css" media="all" />
	<link rel='stylesheet' href='css/font-awesome.css' type='text/css' media='all' />
	<link rel='stylesheet' href='fonts/socialico/stylesheet.css' type='text/css' media='all' />
	<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed%3A300%7CPlayfair+Display%3A400italic&#038;ver=3.4.1' type='text/css' media='all' />

	<!-- JavaScripts -->
	<script type="text/javascript">
		var yiw_prettyphoto_style = 'pp_default';
	</script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.cycle.min.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
	<script type="text/javascript" src="js/jquery.tipsy.js"></script>
	<script type="text/javascript" src="js/jquery.tweetable.js"></script>
	<script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
	<script type="text/javascript" src="js/jquery.flexslider.min.js"></script>
	<script type="text/javascript" src="js/jquery.aw-showcase.js"></script>
	<script type="text/javascript" src="js/superfish.js"></script>
	<script type='text/javascript' src="js/jquery.eislideshow.js"></script>
	<script type='text/javascript' src="js/swfobject.js"></script>
	<script type='text/javascript' src='js/jquery.cookie.js'></script>
	<script type='text/javascript' src='js/buttons.min.js'></script>
	<script type='text/javascript' src='js/layerslider.kreaturamedia.jquery-min.js'></script>
	<script type='text/javascript' src='js/jquery.quicksand.js'></script>

	<link rel="stylesheet" type="text/css" media="all" src="bootstrap.min.css" />
	<script type='text/javascript' src='js/bootstrap.min.js'></script>
	<style>
	div.registerDiv{
		position: absolute; 
		left: 0;
		top:0;
		bottom: 0;
		right: 0;
		max-height: 100%;
		max-width: 100%;
		margin: 0 auto;
	}
	table.registerTable{
		font-size: 16px;
		table-layout: fixed;
	}
	table.registerTable td{
		font-style: bold;
	}
	table.registerTable input{
		border: 1px solid #DEDEDE;
		width: 213px;
		height: 36px;
		font-size: 14px;
	}
	table.registerTable button{
		width: 170px;
		height: 36px;
		border-radius: 2px;
		color: white;
		background-color: #C40000;
		border-width: 0px;
	}
	td.registerTip{
		font-weight: bold;
	}
	td.registerTableLeftTD{
		width: 300px;
		text-align: right;
		font-style: bold;
	}
	td.registerTableRightTD{
		width: 300px;
		text-align: left;
		font-style: bold;
	}
	td.registerButtonTD{
		text-align: center;
	}
	h5 {
		color: white;
	}
	h2 {
		color: white;
		font-size: 40px;
	}
</style>
<script>
	$(function(){
	
	<c:if test="${!empty msg}">
	$("span.errorMessage").html("${msg}");
	$("div.registerErrorMessageDiv").css("visibility","visible");		
	</c:if>
	
	$(".registerForm").submit(function(){
		if(0==$("#firstname_user").val().length){
			$("span.errorMessage").html("Enter the firstname, please.");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		
		if(0==$("#lastname_user").val().length){
			$("span.errorMessage").html("Enter the lastname, please.");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		
		if(0==$("#email").val().length){
			$("span.errorMessage").html("Enter the email, please.");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		
		if(0==$("#password").val().length){
			$("span.errorMessage").html("Enter the password, please.");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		
		if(0==$("#repeatpassword").val().length){
			$("span.errorMessage").html("Re-enter the password, please.");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		
		if($("#password").val() !=$("#repeatpassword").val()){
			$("span.errorMessage").html("Repeat password doesn't conform with password.");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}
		if(0==$("#mobile_number").val().length){
			$("span.errorMessage").html("Enter the mobile number, please.");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}
		if(0==$("#number_id_card").val().length){
			$("span.errorMessage").html("Enter the ID Card number, please.");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}	

		return true;
	});
})
</script>
</head>
<body class="no_js responsive boxed-layout chrome ">
	<div class="registerDiv" align="center">
		<h2>OpenWallet</h2>
		<form method="post" action="foreregister">
		<table align="center" class="registerTable">
			<tbody><tr>
				<td class="registerTip registerTableLeftTD">Create Account</td>
				<td></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">First name</td>
				<td class="registerTableRightTD" ><input type="text" name="firstname_user" id="firstname_user"></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">Last name</td>
				<td class="registerTableRightTD" ><input type="text" name="lastname_user" id="lastname_user"></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">Email</td>
				<td class="registerTableRightTD" ><input type="email" name="email" id="email"></td>
			</tr>     
			<tr>
				<td class="registerTableLeftTD">Password</td>
				<td class="registerTableRightTD"><input type="password" placeholder="At least 6 characters" name="password" id="password"> </td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">Re-enter password</td>
				<td class="registerTableRightTD"><input type="password" id="repeatpassword"> </td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">Birthday</td>
				<td class="registerTableRightTD"><input type="date" id="birthday" name="birthday"> </td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">Mobile number</td>
				<td class="registerTableRightTD"><input type="text" id="mobile_number"> </td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">ID Card Number</td>
				<td class="registerTableRightTD"><input type="text" id="number_id_card"> </td>
			</tr>
			<tr>
				<td class="registerButtonTD" colspan="2">
					<a href="foreregister"><button>Create your OpenWallet account</button></a>
					<h5 color:white;>By Creating your OpenWallet account, you agree to OpenWallet's Conditions of Use and Privacy Notice.</h5>
				</td>
			</tr>   
			<tr>
				<td colspan="2">
					<h4>Already have an account? >><a href="login.jsp" style="color: black;">Sign in</a></h4>
				</td>
			</tr>      
			<tr>
				<td colspan="2">
					<h4>Wanna go back to home page? >><a href="home.jsp" style="color: black;">Go to homepage</a></h4>
				</td>
			</tr>       

		</tbody></table>
	</form>
	</div>
	<script type="text/javascript">

		var _gaq = _gaq || [];
		_gaq.push(['_setAccount', 'UA-36516261-21']);
		_gaq.push(['_trackPageview']);

		(function() {
			var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		})();

	</script>       
</body>

</html>

