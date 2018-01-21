<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
	$(function() {
		$("#addForm").submit(function() {
			if (!checkEmpty("seller", "Product Seller"))
				return false;
			if (!checkEmpty("name_product", "Product Name"))
				return false;
			if (!checkEmpty("description", "Description"))
				return false;
			if (!checkNumber("price", "Product Price"))
				return false;
			if (!checkInt("stock", "Product Stock"))
				return false;
			if (!checkEmpty("create_date_product", "Product Create Date"))
				return false;
			if (!checkEmpty("origin", "Product Origin"))
				return false;
			if (!checkEmpty("brand", "Product Brand"))
				return false;
			if (!checkEmpty("color", "Product Color"))
				return false;
			if (!checkEmpty("material", "Product Material"))
				return false;
			return true;
		});
	});
</script>

<title>Product Admin</title>


<div class="workingArea">

	<ol class="breadcrumb">
	  <li><a href="admin_category_list">All Categories</a></li>
	  <li><a href="admin_product_list?id_category=${c.id_category}">${c.name_category}</a></li>
	  <li class="active">Product Admin</li>
	</ol>



	<div class="listDataTableDiv">
		<table
			class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>Image</th>
					<th>Seller</th>
					<th>Name</th>
					<th width="53px">Price</th>
					<th width="53px">Stock</th>
					<th>Create Date</th>
					<th>Origin</th>
					<th>Sold</th>
					<th>Brand</th>
					<th>Color</th>
					<th>Material</th>
					<th width="42px">Edit</th>
					<th width="42px">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ps}" var="p">
					<tr>
						<td>${p.id_product}</td>
						<td><img height="40px" src="img/product/${p.id_product}.jpg"></td>
						<td>${u.name_user}</td>
						<td>${p.name_product}</td>
						<td>${p.price}</td>
						<td>${p.stock}</td>
						<td>${p.create_date_product}</td>
						<td>${p.origin}</td>
						<td>${p.sold}</td>
						<td>${p.brand}</td>
						<td>${p.color}</td>
						<td>${p.material}</td>
						<td><a href="admin_product_edit?id=${p.id_product}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a deleteLink="true"
							href="admin_product_delete?id=${p.id_product}"><span
								class="glyphicon glyphicon-trash"></span></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp"%>
	</div>

	<div class="panel panel-warning addDiv">
		<div class="panel-heading">Add New Product</div>
		<div class="panel-body">
			<form method="post" id="addForm" action="admin_product_add">
				<table class="addTable">
					<tr>
						<td>Seller</td>
						<td><input id="id_user" name="id_user" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Cagetory</td>
						<td>
							<select name="name_category" id="name_category">
								<c:forEach items="${cs}" var="c">
									<option>${c.name_category}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input id="name_product" name="name_product" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><input id="description" name="description" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input id="price" name="price" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Stock</td>
						<td><input id="stock" name="stock" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Create Date</td>
						<td><input id="create_date_product" name="create_date_product" type="date" 
							class="form-control"></td>
					</tr>
					<tr>
						<td>Origin</td>
						<td><input id="origin" name="origin" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Brand</td>
						<td><input id="brand" name="brand" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Color</td>
						<td><input id="color" name="color" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>Material</td>
						<td><input id="material" name="material" type="text"
							class="form-control"></td>
					</tr>
					<tr>
                        <td>Category Image</td>
                        <td>
                            <input id="categoryPic" accept="image/*" type="file" name="filepath" />
                        </td>
                    </tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="id_category" value="${c.id_category}">
							<a href="admin_product_add"><button class="btn btn-success">Submit</button></a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</div>

<%@include file="../include/admin/adminFooter.jsp"%>
