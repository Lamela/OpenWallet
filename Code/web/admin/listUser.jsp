<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
</script>

<title>User Admin</title>


<div class="workingArea">
	

	<br>
	<h1 class="label label-info" style="font-size: 16pt">User Admin</h1>
	<br>
	
	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>User Firstname</th>
					<th>User Lastname</th>
					<th>User Birthday</th>
					<th>User Type User</th>
					<th>User Premium</th>
					<th>User Email</th>
					<th>User Password</th>
					<th>User Mobile Number</th>
					<th>User Number ID Card</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${us}" var="u">
				<tr>
					<td>${u.id_user}</td>
					<td>${u.firstname_user}</td>
					<td>${u.lastname_user}</td>
					<td>${u.birthday}</td>
					<td>${u.type_user}</td>
					<td>${u.premium}</td>
					<td>${u.email}</td>
					<td>${u.password}</td>
					<td>${u.mobile_user}</td>
					<td>${u.number_id_card}</td>
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
