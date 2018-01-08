<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>

<script>
	$(function(){
		$("#addForm").submit(function(){
			if(!checkEmpty("name","Category Name")) {
				return false;
			}
			if(!checkEmpty("categoryPic", "Category Picture")) {
				return false;
			}
			return true;
		});
	});
</script>

<title>Category Management</title>

<div class="workingArea">
	<br>
	<br>

	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>Image</th>
					<th>Category Name</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${thecs}" var="c">
				<tr>
					<td>${c.id_category}</td>
					<td><img height="40px" src="../img/category/${c.id_category}.jpg"></td>
					<td>${c.name_category}</td>
                    <td><a href="admin_category_edit?id=${c.id_category}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id_category}"><span class="glyphicon glyphicon-trash"></span></a></td>
                   
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
     
    <div class="panel panel-warning addDiv">
      <div class="panel-heading">Add new category</div>
      <div class="panel-body">
            <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>Category Name</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Category Image</td>
                        <td>
                            <input id="categoryPic" accept="image/*" type="file" name="filepath" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">Submit</button>
                        </td>
                    </tr>
                </table>
            </form>
      </div>
    </div>
     
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>
