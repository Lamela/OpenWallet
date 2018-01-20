<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>
  <!-- PAGE META -->
			<div id="page_meta" class="home-section">
			    <div class="inner group">
			        <div class="meta-left">
			            <h2 class="page-title">Account Management</h2>
			        </div>
			    </div>
			</div>
			<!-- /PAGE META -->        
			<div id="primary" class="layout-sidebar-right home-section">
			    <div class="inner group">
			        <!-- START CONTENT -->
			        <div id="content" class="group">
			            <div class="page type-page status-publish hentry group">
			                
			                
			                <h3>General information</h3>
			                <table class="short-table grey" style="width: 100%" cellspacing="0" cellpadding="0" >
			                    <thead>
			                        <tr>
			                            <th><h3>Personal information</h3></th>
			                            <th></th>
			                            <th></th>
			                            <th></th>

			                        </tr>
			                    </thead>
			                    <tbody>
			                        <tr>
			                            <th class="features">First Name:</th>
			                            <td > <input type="text" name="first_name" id="first_name"   ng-model="first_name" required></td>
			                           
			                        </tr>
                                    <tr>
			                            <th class="features">Lasr Name:</th>
			                            <td > <input type="text" name="last_name" id="last_name"   ng-model="last_name" required></td>
			                           
			                        </tr>
                                    <tr>
			                            <th class="features">Email:</th>
			                            <td > <input type="email" name="email" id="email"   ng-model="email" required></td>   
			                        </tr>
                                    <tr>
			                            <th class="features">Actual password:</th>
			                            <td > <input type="password" name="password" id="password"   placeholder="Enter actual password for all information changes" required></td>   
                                    </tr>
                                    <tr>
			                            <th class="features">New password:</th>
			                            <td > <input type="password" name="npassword" id="password"   placeholder="Enter new password if you want to change your password"></td>   
                                    </tr>
                                    <tr>
			                            <th class="features">Re-enter new password:</th>
			                            <td > <input type="password" name="npassword2" id="password"   placeholder="Re-Enter new password if you want to change your password"></td>   
                                    </tr>
                                    <tr>
                                        <td class="registerButtonTD" colspan="2">
                                            <a href="Info_change_confirm.html"><button type="submit">Change your information</button></a>
                                        </td>
                                    </tr>   
			                    </tbody>
			                </table>

			                <table class="short-table blue" style="width: 100%" cellspacing="0" cellpadding="0" >
			                    <thead>
			                        <tr>
			                            <th><h3>Recent purchases</h3></th>
			                            <th>Date</th>
			                            <th>Price</th>
			                            <th>Detail</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <tbody>
                                        <tr>
                                            <th class="features"><p ng-bind="namep1"></p></th>
                                            <td><p ng-bind="datep1"></p></td>
                                            <td><p ng-bind="price1"></p></td>
                                            <td><a href="order_detail.html"><button type="submit">Detail</button></a></td>
                                     
                                        </tr>
                                        <tr>
                                            <th class="features"><p ng-bind="namep2"></p></th>
                                            <td><p ng-bind="datep2"></p></td>
                                            <td><p ng-bind="price2"></p></td>
                                            <td><a href="order_detail.html"><button type="submit">Detail</button></a></td>
                                     
                                        </tr>
                                        <tr>
                                            <th class="features"><p ng-bind="namep3"></p></th>
                                            <td><p ng-bind="datep2"></p></td>
                                            <td><p ng-bind="price2"></p></td>
                                            <td><a href="order_detail.html"><button type="submit">Detail</button></a></td>
                                     
                                        </tr>

    
                                    </tbody>
			                </table>
                            
                            <table class="short-table red" style="width: 100%" cellspacing="0" cellpadding="0" >
			                    <thead>
			                        <tr>
			                            <th><h3>Premium </h3></th>
			                            <th></th>
			                            
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <tbody>
                                            <tr>
                                                    <th class="features">Your premuim status:</p></th>
        
                                                    <td><p ng-bind="statPremium"></p></td>
                                                </tr>
                                        <tr>
                                            <th class="features">Check our Premium Services</p></th>

                                            <td><a href="premium.html"><button type="submit">Go!</button></a></td>
                                        </tr>
                                    </tbody>
			                </table>
			            </div>
			        </div>
			        <!-- END CONTENT -->
			       
			    </div>
			</div>
			<div class="clear"></div>
		</div>     
        <!-- END WRAPPER -->
        
        <%@include file="./include/Footer.jsp"%>		

<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36516261-21']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
<script>
    var app = angular.module('accinfo', []);
    app.controller('Ctrlinfo', function($scope) {
        $scope.first_name= "First name retrieved from DB";
        $scope.last_name= "Last name retrieved from DB";
        $scope.email= "Email name retrieved from DB";
        $scope.namep1= "Product name retrieved from DB";
        $scope.datep1= "Date retrieved from DB";
        $scope.price1= "Price retrieved from DB";
        $scope.namep2= "Product name retrieved from DB";
        $scope.datep2= "Date retrieved from DB";
        $scope.price2= "Price retrieved from DB";
        $scope.namep3= "Product name retrieved from DB";
        $scope.datep3= "Date retrieved from DB";
        $scope.price3= "Price retrieved from DB";
        $scope.statPremium= "Premuim status retrieved from DB";
    });
</script>
			
    </body>
</html>

