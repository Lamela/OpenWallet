<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>
 <!-- PAGE META -->
    <div id="page_meta" class="home-section">
        <div class="inner group">
            <div class="meta-left">
                <h2 class="page-title">Add a new product</h2>
            </div>
        </div>
    </div>
    <!-- /PAGE META -->        
    <div id="primary" class="layout-sidebar-right home-section">
        <div class="inner group">
            <!-- START CONTENT -->
            <table align="center" class="productTable">
                <tbody><tr>
                    <td class="registerTip productTableLeftTD"><h3>Product information</h3></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="productTableLeftTD">Name</td>
                    <td class="productTableRightTD" ><input type="name" name="name" id="productname" required></td>
                </tr>
                <tr>
                    <td class="productTableLeftTD">Product Picture</td>
                    <td class="productTableRightTD" ><input type="file" name="picture" id="picture" required></td>
                </tr>
                <tr>
                    <td class="productTableLeftTD">Department</td>
                    <td class="productTableRightTD" ><input list="departments" name="dept" required></td>
                    <datalist id="departments">
                            <option value="Boonks & Audible">
                            <option value="Electronics, Computers & Office">
                            <option value="Home, Garden, Pets & Tools">
                            <option value="Food & Grocery">
                            <option value="Beauty & Health">
                            <option value="Toys, Kids & Baby">
                            <option value="Clothing, Shoes & Jewelry">
                            <option value="Handmade">
                            <option value="Sports & Outdoors">
                            <option value="Automotive & industrial">                    
                          </datalist>
                </tr>       
                <tr>
                    <td class="productTableLeftTD">Price</td>
                    <td class="productTableRightTD"><input type="number" id="price" required> </td><td>€</td>
                  
                </tr>
                <tr>
                    <td class="productTableLeftTD">Color</td>
                    <td class="productTableRightTD"><input type="color" id="color" > 
                  
                </tr>
                <tr>
                    <td class="productTableLeftTD">Expiration date</td>
                    <td class="productTableRightTD"><input type="date" id="expdate" > 
                  
                </tr>
                <tr>
                    <td class="productTableLeftTD">Weight</td>
                    <td class="productTableRightTD"><input type="number" id="weight" > </td><td>g</td>
                  
                </tr>
                <tr>
                    <td class="productTableLeftTD">Place of origin</td>
                    <td class="productTableRightTD"><input type="place" id="weight" > 
                  
                </tr>
                <tr>
                    <td class="productTableLeftTD">Brand</td>
                    <td class="productTableRightTD"><input  id="brand" > 
                  
                </tr>   
                <tr>
                    <td class="productTableLeftTD">Warranty</td>
                    <td class="productTableRightTD"><input type="month" id="warranty" > 
                  
                </tr>     
                <tr>
                    <td class="productTableLeftTD">Material</td>
                    <td class="productTableRightTD"><input type="material" id="material" > 
                  
                </tr>          
                <tr>
                        <td class="productTableLeftTD">Description</td>
                        <td><textarea name="description" id="descriptrion" cols="70" rows="5" placeholder="Entre your detailed description of your product here"></textarea></td>
                    </tr>
                <tr>
                    <td class="registerButtonTD" colspan="2">
                        <a href="product_list.html"><button type="submit">Add your product</button></a>
                    </td>
                </tr>   
                <tr>
                    <td colspan="2">
                        <a href="user_profile.html" style="color: black;"><button>Return</button></a>
                    </td>
                </tr>    
            </tbody></table>



                    
                </div>
            </div>
            <!-- END CONTENT -->
            
        </div>
    </div>
    <div class="clear"></div>
</div>     
<!-- END WRAPPER -->

		
<%@include file="./include/Footer.jsp"%>