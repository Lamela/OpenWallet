<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>
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
                        <a href="index.html"><i class="icon-home"></i>Departements</a>
                        <ul class="sub-menu">
                            <li><a href="home-ii-stretched.html">Boonks & Audible</a></li>
                            <li><a href="home-iii-portfolio.html">Electronics, Computers & Office</a></li>
                            <li><a href="home-iv.html">Home, Garden, Pets & Tools</a></li>
                            <li><a href="home-v.html">Food & Grocery</a></li>
                            <li><a href="home-vi.html">Beauty & Health</a></li>
                            <li><a href="home-vii.html">Toys, Kids & Baby</a></li>
                            <li><a href="home-ix-with-tab.html">Clothing, Shoes & Jewelry</a></li>
                            <li><a href="home-x.html">Handmade</a></li>
                            <li><a href="home-x.html">Sports & Outdoors</a></li>
                            <li><a href="home-x.html">Automotive & industrial</a></li>
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
    <!-- /PAGE META -->        
    <div id="primary" class="layout-sidebar-right home-section">
        <div class="inner group">
            <!-- START CONTENT -->
            <div id="content" class="group" style="margin-right:0px;width:650px;padding-right:0px">
                <div class="page type-page status-publish hentry group">
                    <h2 class="title-post-page">Shopping Cart</h2>
                    <!--<div clas="cartTitle pull-right">
                        <span>Chosen product</span>
                        <span class="cartTitlePrice">€0.00</span>
                        <button class="createOrderButton" disabled="disabled">Proceed to checkout</button>
                    </div>-->
                    <table class="short-table white" style="width: 95%" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Product</th>
                                <th>Price per unit</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><img src="images/404.png" width="40px" height="40px"/></td>
                                <td>iPhone X</td>
                                <td><i class="yiw-sc-tick icon-ok" style="color:#23b10b;font-size:14px;">800€</i></td>
                                <td>
                                    <div class="cartProductChangeNumberDiv">
                                        <a href="#nowhere" class="numberMinus" >-</a>
                                        <input value="1" class="orderItemNumberSetting" style="border: solid 1px #AAAAAA;
                                            width: 42px;
                                            display: inline-block;"/>
                                        <a href="#nowhere" class="numberPlus">+</a>
                                    </div>
                                </td>
                                <td><i class="yiw-sc-tick icon-ok" style="color:#23b10b;font-size:14px;">800€</i></td>
                                <td><a href="#">Delete</a></td>
                            </tr>
                        </tbody>
                    </table>
                    <!--<div class="cartFoot">
                        <div class="pull-right">
                            <span>You have chosen <span class="cartSumNumber">0</span> product</span>
                            <span>Summary: </span>
                            <span class="cartSumPrice">€0.00</span>
                            <button class="createOrderButton" disabled="disabled">Proceed to checkout</button>
                        </div>
                    </div>-->
                </div>
            </div>
            <!-- END CONTENT -->
            <!-- START SIDEBAR -->
            <div id="sidebar" class="group one-fourth last" style="float:left;margin-left:0px;padding-left:0px">
                <div class="price-table" style="margin:0px;padding:0px;float:left">
                    <div class="head">
                        <p>Subtotal:</p>
                        <h2 class="price">45.0 $</h2>
                    </div>
                    <div class="body">
                        <ul>
                             <li>Morbi est elit, imperdiet sit amet</li>
                             <li>Lorem ipsum seget, egestas in leo.</li>
                             <li>Morbi est elit, imperdiet sit amet</li>
                             <li>Lorem ipsum seget, egestas in leo.</li>
                         </ul>
                         <p class="more"><a href="#">Proceed to checkout</a></p>
                     </div>
                 </div>
            </div>
            <!-- END SIDEBAR -->    
        </div>
    </div>
</div>     
<!-- END WRAPPER -->
<%@include file="./include/Footer.jsp"%>