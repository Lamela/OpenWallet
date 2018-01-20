<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>


    <div id="primary" class="layout-sidebar-right home-section">
    <div class="inner group">
        <!-- START CONTENT -->
        <div id="content" class="group">
            <div class="clear"></div>
            <div class="posts">
                <div class="bl_services type-bl_services status-publish hentry hentry-post group internal-post">
                    <h2>Product information</h2>
                    <div class="post_header group">
                        <img src="images/chiot-husky.jpg" class="internal wp-post-image" alt="socialmarketing" title="socialmarketing" />                            
                    </div>
                    <table align="center" class="productTable">
                            <tbody><tr>
                                <td class="registerTip productTableLeftTD"><h3>Product information</h3></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="productTableLeftTD">Name:</td>
                                <td class="productTableRightTD" ><p>Choit husky</p></td>
                            </tr>
                            <tr>
                                <td class="productTableLeftTD">Department:</td>
                                <td class="productTableRightTD" ><p>Home, Garden, Pets & Tools</p></td>

                            </tr>       
                            <tr>
                                <td class="productTableLeftTD">Price:</td>
                                <td class="productTableRightTD"><p>500</p> </td><td>€</td>
                              
                            </tr>
                            <tr>
                                <td class="productTableLeftTD">Color:</td>
                                <td class="productTableRightTD"><p>Black&White</p>
                              
                            </tr>
                            <tr>
                                <td class="productTableLeftTD">Expiration date:</td>
                                <td class="productTableRightTD"><p>N/A</p>
                              
                            </tr>
                            <tr>
                                <td class="productTableLeftTD">Weight:</td>
                                <td class="productTableRightTD"><p>1000</p> </td><td>g</td>
                              
                            </tr>
                            <tr>
                                <td class="productTableLeftTD">Place of origin:</td>
                                <td class="productTableRightTD"><p>Sibérie</p>
                              
                            </tr>
                            <tr>
                                <td class="productTableLeftTD">Brand:</td>
                                <td class="productTableRightTD"><p>N/A</p> 
                              
                            </tr>   
                            <tr>
                                <td class="productTableLeftTD">Warranty:</td>
                                <td class="productTableRightTD"><p>3 Months</p> 
                              
                            </tr>     
                            <tr>
                                <td class="productTableLeftTD">Material:</td>
                                <td class="productTableRightTD"><p>Meat&Fur&Bones</p> 
                              
                            </tr>          
                            <tr>
                                    <td class="productTableLeftTD">Description:</td>
                                    <td class="productTableLeftTD"><p>Magnifiques chiots type Husky non LOF

                                            Femelles disponibles 
                                            
                                            Au prix de 890€
                                            
                                            Plus de 8 semaines (sevré)
                                            
                                            SIRET : 44295867400016
                                            
                                            Paiement jusqu'en 6 fois (voir conditions dans notre établissement)
                                            
                                            PLUS DE 100 CHIOTS EN EXPO-VENTE UNIQUEMENT NÉS EN FRANCE
                                            
                                        
                                            Tel : 04 90 66 83 47
                                            
                                            
                                            Tous nos chiots sont vendus : 
                                            
                                            .Identifiés par puce électronique ou tatouage
                                            .Vaccinés par le vétérinaire.
                                            .Vermifugés et traités contre les parasites internes et externes (vignette dans le carnet)
                                            .Examinés par le vétérinaire sanitaire (certificat de bonne santé)
                                            .Vendus avec un contrat de vente et de garantie.
                                            .Deux mois d'assurance accident offerte sans engagement (Anima Solution)
                                            .Tous les conseils élémentaires nécessaires pour le départ du chiot en fonction de ses caractéristiques.
                                            
                                            Photos non contractuelles</p></td>
                                </tr> 
                        </tbody></table>
                </div>
            </div>
        </div>
        <!-- START LATEST NEWS -->
        <div id="sidebar" class="group one-fourth last">
            
                <div id="text-image-5" class="widget-1 widget-first widget text-image">
                    <h3>Add to cart <span>now!</span></h3>
                    <div class="text-image" style="text-align:left"><img src="images/enjoy.jpg"  /></div>
                    <td><a href="cart.html"><button type="submit">Add</button></a></td>
                    </p>
                </div>
                
                
                </div>
                
            </div>
            <!-- END LATEST NEWS -->
        <table class="short-table white" style="width: 100%" cellspacing="0" cellpadding="0" >
                <thead>
                    <tr >
                        <th><h3>Recent comments</h3></th>
                    </tr>
                </thead>
                <tbody>
                    <tbody>
                        <tr>
                            <th class="features"><p ng-bind="comment1"></p></th>

                        </tr>
                        <tr>
                                <th class="features"><p ng-bind="comment2"></p></th>
                        </tr>
                        <tr>
                                <th class="features"><p ng-bind="comment3"></p></th>
                     
                        </tr>


                    </tbody>
            </table>
            
        <!-- END CONTENT -->
                
		    </div>
		</div>
		<div class="clear"></div>
		</div>     
        <!-- END WRAPPER -->
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
                        $scope.comment1= "Comment retrieved from DB";
                        $scope.comment2= "Comment retrieved from DB";
                        $scope.comment3= "Comment retrieved from DB";
                    });
                </script>
            </body>
        </html>

        <%@include file="./include/Footer.jsp"%>