<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>
	<!-- START WRAPPER -->
    <div class="wrapper group" style="margin-top:30px">
        <!-- PAGE META -->
        <div class="inner home-testimonials home-section group">
            <div class="inner group">
                <!-- START CONTENT -->
                <div id="content" class="group">
                    <h1>Shipping Address</h1>
                    <form action="post">
                        <label for="full_name">Full name :</label><br/>
                        <input id="full_name"/><br/>
                        <label for="add_line1">Address line 1 :</label><br/>
                        <input id="add_line1" placeholder="Street address, P.O. box, company name, c/o"/><br/>
                        <label for="add_line2">Address line 2 :</label><br/>
                        <input id="add_line2" placeholder="Apartment, suite, unit, building, floor, etc."/><br/>
                        <label for="add_city">City :</label><br/>
                        <input id="add_city"/><br/>
                        <label for="add_region">State/Province/Region :</label><br/>
                        <input id="add_region"/><br/>
                        <label for="add_zip">ZIP :</label><br/>
                        <input id="add_zip"/><br/>
                        <label for="add_country">Country :</label><br/>
                        <input id="add_country"/><br/>
                        <label for="phone">Phone number :</label><br/>
                        <input id="phone"/><br/>
                        <br/>
                        <input type="submit" value="Confirm and Pay" id="shipToThisAddress"/>
                    </form>
                </div>
                <!-- END CONTENT -->
            </div>
        </div>
        <!-- END PAGE META -->
    </div>
    <!-- END WRAPPER -->
<%@include file="./include/Footer.jsp"%>