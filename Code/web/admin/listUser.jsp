<!-- 模仿天猫整站j2ee 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
</script>

<title>User Admin</title>


<div class="workingArea">
	<h1 class="label label-info" >User Admin</h1>

	<br>
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
