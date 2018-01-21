<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>
<script>
    var deleteOrderItemid = 0;
    $(function(){
        $("a.deleteOrderItem").click(funciton (){
            var oiid = $(this).attr("oiid")
            deleteOrderItemid = oiid;
            if(deleteOrderItem){
                var page="foredeleteOrderItem";
                $.post(
                    page,
                    {"oiid":deleteOrderItemid},
                    function(result){
                        if("success"==result){
                            $("tr.cartProductItemTR[oiid="+deleteOrderItemid+"]").hide();
                        }
                        else{
                            location.href="login.jsp";
                        }
                    }
                );
            }
        });
    });
</script>
 <!-- START WRAPPER -->
 <div class="wrapper group">
  
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
                            <c:forEach items="${ois}" var="oi">
                            <tr oiid="${oi.id_item_order}" class="cartProductItemTR">
                                <td><img src="img/product/${oi.id_product}.jpg" width="40px" height="40px"/></td>
                                <td>${oi.product.name_product}</td>
                                <td><i class="yiw-sc-tick icon-ok" style="color:#23b10b;font-size:14px;">${oi.product.price}</i></td>
                                <td>
                                    <div class="cartProductChangeNumberDiv">
                                        <a href="#nowhere" class="numberMinus" >-</a>
                                        <input value="${oi.number_item_order}" class="orderItemNumberSetting" style="border: solid 1px #AAAAAA;
                                            width: 42px;
                                            display: inline-block;"/>
                                        <a href="#nowhere" class="numberPlus">+</a>
                                    </div>
                                </td>
                                <td><i class="yiw-sc-tick icon-ok" style="color:#23b10b;font-size:14px;">${oi.product.price*oi.number_item_order}</i></td>
                                <td><a class="deleteOrderItem" oiid="${oi.id_item_order}" href="#">Delete</a></td>
                            </tr>
                            </c:forEach>
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