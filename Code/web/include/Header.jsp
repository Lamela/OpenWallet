<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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

        <link rel="stylesheet" type="text/css" media="all" href="bootstrap.min.css" />
        <script type='text/javascript' src='js/bootstrap.min.js'></script>

        <style>
        div.searchDiv{
            background-color: #000000;
            width: 400px;
            margin: 50px auto;
            padding: 1px;
            height: 40px;
            display: block;
            margin-bottom: 10px;
        }
        div.searchDiv input{
            width: 275px;
            border: 1px solid transparent;
            height: 36px;
            margin: 1px;
            outline:none;
            font-style: italic;
        }
        div.searchDiv button{
            width: 110px;
            border: 1px solid transparent;
            background-color: #000000;
            color: white;
            font-size: 20px;
            font-weight: bold;
        }
        img.logo{
            position: absolute;
            left: 0px;
            top: 30px;
            z-index:-1;
        }
        body{
            font-size:12px;
            font-family:Arial;
        }
        a{
            color:#999;
        }
        a:hover{
            text-decoration:none;
            color:#C40000;
        }
        </style>
    </head>
    <body class="no_js responsive boxed-layout chrome ">

        <!-- TOPBAR -->
        <div id="topbar">
            <div class="inner group">

                <div class="topbar-left">
                    <!-- START TWITTER -->
                    <div id="twitter-slider" class="group">
                        <div class="tweets-list"></div>
                        <script type="text/javascript" src="js/twitter.js" ></script>
                    </div>
                    <!-- END TWITTER -->
                </div>

                <div class="topbar-right">
                    <ul class="topbar-level-1">
                        <!-- <li>
                            <a href="#">Top bar menu</a>
                            <ul class="sub-menu">
                                <li><a href="#">And submenu</a></li>
                                <li><a href="#"><i class="icon-home"></i>with icons</a></li>
                            </ul>
                        </li> -->
                        <li><a href="home.jsp"><i class="icon-envelope"></i>Home</a></li>
                        <c:if test="${!empty user}">
                            <li><a href="login.jsp"><i class="icon-envelope"></i>${user.firstname_user}</a></li>
                            <li><a href="forelogout"><i class="icon-envelope"></i>Logout</a></li>     
                        </c:if>

                        <c:if test="${empty user}">
                            <li><a href="login.jsp"><i class="icon-envelope"></i>Login</a></li>
                            <li><a href="register.jsp"><i class="icon-envelope"></i>Register</a></li>     
                        </c:if>
                            <li><a href="forebought"><i class="icon-envelope"></i>My orders</a></li>
                            <li><a href="forecart"><i class="cart"></i>Cart</a></li>
                        </ul>
                </div>

            </div>
        </div>
        <!-- END TOPBAR -->
         <!-- START WRAPPER -->
         <div class="wrapper group">
            <!-- START HEADER -->
            <div id="header" class="group">
                <div class="group inner">
                    
                    <!-- START LOGO -->
                    <div id="logo" class="group">
                        <h1>
                            <a class="logo-text" href="index.html" title="Mem&eacute;nto">OpenWallet</a>                        
                        </h1>
                        <p>Probably the best online shop</p>
                    </div>
                    <!-- END LOGO -->
                    <!-- START NAV -->
                    <div id="nav" class="group">
                        <ul id="menu-main-nav" class="level-1">
                            <li>
                                <a href="index.html"><i class="icon-home"></i>Categories</a>
                                <ul class="sub-menu">
                                    <c:forEach items="${cs}" var="c">
                                        <li><a href="forecategory?cid=${c.id_category}">${c.name_category}</a></li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </div>
                        <div id="nav" class="group">
                           <div class="searchDiv">

                            <input type="text" placeholder="I'm going to buy..." name="keyword">
                            <button class="searchButton" type="submit">Search</button>
                        </div>
                    </div>
                    <!-- END NAV -->     
                </div>
            </div>
            <!-- END HEADER --> 