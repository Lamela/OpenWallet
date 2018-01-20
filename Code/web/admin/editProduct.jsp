
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>


<title>Edit product</title>

<script>
$(function() {
	$("#editForm").submit(function() {
		if (!checkEmpty("name", "Product Name"))
			return false;
		if (!checkNumber("price", "Product price"))
			return false;
		if (!checkInt("stock", "Product Stock"))
			return false;
		return true;
	});
});
</script>

<div class="workingArea">
	<ol class="breadcrumb">
	  <li><a href="admin_category_list">All categories</a></li>
	  <li class="active">${p.name}</li>
	  <li class="active">Edit Product</li>
	</ol>
	
	<div class="panel panel-warning editDiv">
		<div class="panel-heading">Edit product</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="admin_product_update">
				<table class="editTable">
					<tr>
						<td>Product Name</td>
						<td><input id="name" name="name" value="${p.name}"
							type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>Product price</td>
						<td><input id="orignalPrice" value="${p.orignalPrice}" name="orignalPrice" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Product Stock</td>
						<td><input id="stock"  value="${p.stock}" name="stock" type="text"
							class="form-control"></td>
					</tr>
					<tr>
	    				<td>Product Image</td>
	    				<td>
	    					<input id="productPic" accept="image/*" type="file" name="filepath" />
	    				</td>
	    			</tr>	    
										
					<tr class="submitTR">
						<td colspan="2" align="center">
						<input type="hidden" name="id" value="${p.id}">
						<input type="hidden" name="cid" value="${p.category.id}">
						<button type="submit" class="btn btn-success">Submit</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>