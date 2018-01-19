<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
$(function(){
	$("button.orderPageCheckOrderItems").click(function(){
		var oid = $(this).attr("oid");
		$("tr.orderPageOrderItemTR[oid="+oid+"]").toggle();
	});
});

</script>

<title>Order Admin</title>


<div class="workingArea">
	<br>
    <h1 class="label label-info" style="font-size: 16pt">Orders Admin</h1>
	<br>
	
	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover1  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>Status</th>
					<th>Total Price</th>
					<th width="100px">Item Number</th>
					<th width="100px">User Firstname</th>
					<th width="100px">User Lastname</th>
					<th>Creation Date</th>
					<th>Pay Date</th>
					<th>Delivery Date</th>
					<th>Confirm Date</th>
					<th>Delivery Address</th>
					<th>Invoice Address</th>
					<th width="120px">Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${os}" var="o">
					<tr>
						<td>${o.id_orders}</td>
						<td>${o.status}</td>
						<td>￥<fmt:formatNumber type="number" value="${o.total_price}" minFractionDigits="2"/></td>
						<td align="center">${o.total_number}</td>
						<td align="center">${o.user.firstname}</td>
						<td align="center">${o.user.lastname}</td>
						
						<td><fmt:formatDate value="${o.create_date_order}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><fmt:formatDate value="${o.pay_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><fmt:formatDate value="${o.delivery_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><fmt:formatDate value="${o.confirm_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${o.delivery_address}</td>
						<td>${o.invoice_address}</td>

						<td>
							<button oid=${o.id_order} class="orderPageCheckOrderItems btn btn-primary btn-xs">Details</button>
							
							<c:if test="${o.status=='waitDelivery'}">
								<a href="admin_order_delivery?id=${o.id_order}">
									<button class="btn btn-primary btn-xs">Delivery</button>
								</a>							
							</c:if>
						</td>
					</tr>
					<tr class="orderPageOrderItemTR"  oid=${o.id_order}>
						<td colspan="10" align="center">
							
							<div  class="orderPageOrderItem">
								<table width="800px" align="center" class="orderPageOrderItemTable">
									<c:forEach items="${o.itemsOrders}" var="oi">
										<tr>
											<td align="left">
												<img width="40px" height="40px" src="img/product/${oi.product.id_product}.jpg">
											</td>	
											
											<td>
												<a href="foreproduct?pid=${oi.product.id_product}">
													<span>${oi.product.name}</span>
												</a>											
											</td>
											<td align="right">
											
												<span class="text-muted">${oi.number_item_order}</span>												
											</td>
											<td align="right">
											
												<span class="text-muted">Price：￥${oi.product.price}</span>												
											</td>

										</tr>
									</c:forEach>
								
								</table>
							</div>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp" %>
	</div>
	

	
</div>

<%@include file="../include/admin/adminFooter.jsp"%>
