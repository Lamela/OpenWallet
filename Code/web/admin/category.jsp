<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>
 <!-- START WRAPPER -->
 <div class="wrapper group">
  
    <!-- /PAGE META -->        
    <div id="primary" class="layout-sidebar-right home-section">
        <div class="inner group">
            <!-- START CONTENT -->
            <div id="content" class="group" style="margin-right:0px;width:650px;padding-right:0px">
                <div class="page type-page status-publish hentry group">
                    <h2 class="title-post-page">Category ${c.name_category}</h2>
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
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ps}" var="p">
                                <tr>
                                    <td><img src="img/product/${p.id_product}.jpg" width="40px" height="40px"/></td>
                                    <td>${p.name_product}</td>
                                    <td><i class="yiw-sc-tick icon-ok" style="color:#23b10b;font-size:14px;">${p.price}$</i></td>
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
        </div>
    </div>
</div>     
<!-- END WRAPPER -->
<%@include file="./include/Footer.jsp"%>