<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>


    <div id="primary" class="layout-sidebar-right home-section">
    <div class="inner group">
        <!-- START CONTENT -->
        <div id="content" class="group">

            
                <div class="bl_services type-bl_services status-publish hentry hentry-post group internal-post">
             
                        <h2>Order details</h2>
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
                                        <td>1</td>
                                        <td><i class="yiw-sc-tick icon-ok" style="color:#23b10b;font-size:14px;">800€</i></td>
                                        <td><a href="#">Delete</a></td>
                                    </tr>
                                </tbody>
                            </table>
                            <h2>Select Address</h2>
                        <table class="short-table white" style="width: 95%" cellspacing="0" cellpadding="0">
                                <thead>

                                        <th>Address for</th>
                                        <th>Address selected</th>

                                </thead>
                                <tbody>
                                    <tr>
                                            <td>Shipping </td>
                                            <td class="productTableRightTD" ><input list="address" name="dept" required></td>
                                            <datalist id="address">
                                                    <option value="address1">
                                                    <option value="address2">
                                                    <option value="address3">
">                    
                                             </datalist>
                                    </tr>
                                    <tr>
                                            <td>Billing </td>
                                            <td class="productTableRightTD" ><input list="address" name="dept" required></td>
                                            <datalist id="address">
                                                    <option value="address1">
                                                    <option value="address2">
                                                    <option value="address3">
">                    
                                             </datalist>
                                        </tr>
                                        <tr >
                                                <td colspan="2"><a href="shipping_address.html"><button type="submit">Add new address</button></a></td>

                                        </tr>             
                                    
                                </tbody>
                            </table>
                            <h2>Payment method</h2>
                            <table class="" style="width: 95%" cellspacing="0" cellpadding="0">
                                    <thead>
                                        <tr>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                           
                                        </tr>
                                        <tr> <td><input type="radio" name="pay" value="paypal" required> Card<input type="radio" name="pay" value="paypal" required> Paypal</td></tr>
                                    </tbody>
                                </table>

                </div>
            
        </div>
        <!-- START LATEST NEWS -->
        <div id="sidebar" class="group one-fourth last">
            
                <div id="text-image-5" class="widget-1 widget-first widget text-image">
                    <div class="text-image" style="text-align:left"><img src="images/enjoy.jpg"  /></div>
                    <td><a href="cart.html"><button type="submit">Buy now</button></a></td>
                    </p>
                </div>
                
                
                </div>
                
            </div>
            <!-- END LATEST NEWS -->
            
        <!-- END CONTENT -->
                
        
        

    </div>
</div>
<div class="clear"></div>
</div>     
<!-- END WRAPPER -->
<%@include file="./include/Footer.jsp"%>