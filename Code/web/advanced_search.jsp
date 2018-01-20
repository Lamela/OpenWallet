<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>

        <!-- START WRAPPER -->
        <div class="wrapper group">
            <!-- START HEADER -->
            <div id="header" class="group">
                <div class="group inner">

                    <!-- START LOGO -->
                    <div id="logo" class="group">
                        <h1>
                            <a class="logo-text" href="index.html" title="Mem&eacute;nto">OpenWallet</a>
                        </h1>
                        <p>Probably the best online shop</p>
                    </div>
                    <!-- END LOGO -->
                    <!-- START NAV -->
                    <div id="nav" class="group">
                        <ul id="menu-main-nav" class="level-1">
                            <li>
                                <a href="index.html"><i class="icon-home"></i>Departements</a>
                                <ul class="sub-menu">
                                    <li><a href="home-ii-stretched.html">Boonks & Audible</a></li>
                                    <li><a href="home-iii-portfolio.html">Electronics, Computers & Office</a></li>
                                    <li><a href="home-iv.html">Home, Garden, Pets & Tools</a></li>
                                    <li><a href="home-v.html">Food & Grocery</a></li>
                                    <li><a href="home-vi.html">Beauty & Health</a></li>
                                    <li><a href="home-vii.html">Toys, Kids & Baby</a></li>
                                    <li><a href="home-ix-with-tab.html">Clothing, Shoes & Jewelry</a></li>
                                    <li><a href="home-x.html">Handmade</a></li>
                                    <li><a href="home-x.html">Sports & Outdoors</a></li>
                                    <li><a href="home-x.html">Automotive & industrial</a></li>
                                </ul>
                            </li>
                        </div>
                        <div id="nav" class="group">
                           <div class="searchDiv">

                            <input type="text" placeholder="I'm going to buy..." name="keyword">
                            <button class="searchButton" type="submit">Search</button>
                        </div>
                    </div>
                    <!-- END NAV -->
                </div>
            </div>
            <!-- END HEADER -->
			<!-- /PAGE META -->
			<div id="primary" class="layout-sidebar-right home-section">
        <div class="inner home-row group">
            <div class="widget two-third widget-icon-text group">
              <h2><i class="icon-envelope"></i>Advanced options</h2>
              <h3>Name</h3>
                <input type="text" placeholder="What are you looking for ?" name="advanced_keyword">
                <br/>
                <h3>Price</h3>
                <div data-role="rangeslider">
                        <label for="price-min">Minimum:</label>
                        <input type="number" name="price-min" id="price-min" value="200" min="0" max="100000">
                        <label for="price-max">Maximum:</label>
                        <input type="number" name="price-max" id="price-max" value="800" min="0" max="100000">
                </div>
                <!-- <input type="checkbox" id="price_search">Price</button> -->
                <br/>
                <h3>Category</h3>
                <form>
                  <select name="category">
                    <option value="category 1">Boonks & Audible</option>
                    <option value="category 2">Electronics, Computers & Office</option>
                    <option value="category 3">Home, Garden, Pets & Tools</option>
                    <option value="category 4">Food & Grocery</option>
                    <option value="category 5">Beauty & Health</option>
                    <option value="category 6">Toys, Kids & Baby</option>
                    <option value="category 7">Clothing, Shoes & Jewelry</option>
                    <option value="category 8">Handmade</option>
                    <option value="category 9">Sports & Outdoors</option>
                    <option value="category 10">Automotive & industrial</option>
                  </select>
                </form>
                <br/>
                <h3>Review (minimal rating)</h3>
                <div data-role="rangeslider">
                        <label for="price-min">Minimum:</label>
                        <input type="number" name="price-min" id="price-min" value="0" min="5" max="5">
                        <label for="price-max">Maximum:</label>
                        <input type="number" name="price-max" id="price-max" value="5" min="0" max="5">
                </div>
                <h3>Origin</h3>
                  <input type="text" placeholder="Origin of the product" id="origin_search">
                <h3>Stock</h3>
                  <input type="number" id="stock_search">
                <h3>Brand</h3>
                  <input type="text" id="brand_search">
                <h3>Color</h3>
                  <input type="color" id="color_search">
            </div>
            <button class="searchButton" type="submit">Advanced search</button>

        </div>
			        <!-- END CONTENT -->
			    </div>
			</div>
		</div>
		<!-- END WRAPPER -->

        <%@include file="./include/Footer.jsp"%>