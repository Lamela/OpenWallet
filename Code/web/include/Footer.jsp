<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./modal.jsp"%>
   <div id="footer" class="sidebar-right">
    <div class="group inner footer_row_1 footer_cols_3">

        <div class="widget widget_nav_menu">
            <h3>Get to Know Us</h3>
            <div class="menu-footer-menu-container">
                <ul id="menu-footer-menu" class="menu">

                    <li class="columns2"><a href="features.html">Careers</a></li>
                    <li class="columns2"><a href="#">About OpenWallet</a></li>
                    <li class="columns2"><a href="contact.html">Investor Relations</a></li>
                    <li class="columns2"><a href="testimonials.html">OpenWallet Devices</a></li>

                </ul>
            </div>
        </div>


        <div class="widget widget_nav_menu">
            <h3>Make Money with Us</h3>
            <div class="menu-footer-menu-container">
                <ul id="menu-footer-menu" class="menu">
                    <li class="columns2"><a href="#">Sell on OpenWallet</a></li>
                    <li class="columns2"><a href="contact.html">Become an Affiliate</a></li>
                    <li class="columns2"><a href="features.html">Sell Your Services on OpenWallet</a></li>
                    <li class="columns2"><a href="#">Sell Your Apps on OpenWallet</a></li>
                    <li class="columns2"><a href="testimonials.html">Advertise Your Products</a></li>
                    <li class="columns2"><a href="portfolio.html">Self-Publish with Us</a></li>
                    <li class="columns2"><a href="#">Become an OpenWallet Vendor</a></li>
                </ul>
            </div>
        </div>

        <div class="quick-contact-widget widget two-third last">
            <div class="widget-last widget quick-contact">
                <h3>Quick Contact</h3>
                <form id="contact-form-example" class="contact-form" method="post" action="sendmail.php" enctype="multipart/form-data">
                    <div class="usermessagea"></div>
                    <fieldset>
                        <ul>
                            <li class="text-field">
                                <label for="name-example">
                                    <span class="label">Name</span>
                                </label>
                                <div class="input-prepend"><span class="add-on"><i class="icon-user"></i></span><input type="text" name="name" id="name-example" class="required" value="" /></div>
                                <div class="msg-error"></div>
                            </li>
                            <li class="text-field">
                                <label for="email-example">
                                    <span class="label">Email</span>
                                </label>
                                <div class="input-prepend"><span class="add-on"><i class="icon-envelope"></i></span><input type="text" name="email" id="email-example" class="required email-validate" value="" /></div>
                                <div class="msg-error"></div>
                            </li>
                            <li class="textarea-field">
                                <label for="message-example">
                                    <span class="label">Message</span>
                                </label>
                                <div class="input-prepend"><span class="add-on"><i class="icon-pencil"></i></span><textarea name="message" id="message-example" rows="8" cols="30" class="required"></textarea></div>
                                <div class="msg-error"></div>
                            </li>
                            <li class="submit-button">
                                <input type="text" name="yiw_bot" id="yiw_bot" />
                                <input type="hidden" name="action" value="sendemail" id="action" />
                                <input type="hidden" name="yiw_referer" value="#" />
                                <input type="hidden" name="id_form" value="footer" />
                                <input type="submit" name="yiw_sendemail" value="send message" class="sendmail alignright" />
                            </li>
                        </ul>
                    </fieldset>
                </form>
                <script type="text/javascript">
                    var messages_form_footer = {
                       name: "Insert your name",
                       email: "Insert your email",
                       message: "Insert your message"
                   };
               </script>
           </div>
       </div>

   </div>
</div>


<!-- START FOOTER -->
<div id="copyright" class="group">
    <div class="inner group">
        <div class="left">
            <p>
               Copyright <a href="#"><strong>OpenWallet</strong></a> 2017 -
               Powered by <a href="#" title="Free HTML Template"><strong>OWCompany</strong></a>
           </p>
       </div>
       <div class="right">
        <a href="#" class="socials facebook" style="font-size:30px;" title="Facebook">F</a>
        <a href="#" class="socials twitter" style="font-size:30px;" title="Twitter">L</a>
        <a href="#" class="socials skype" style="font-size:30px;" title="Skype">H</a>
        <a href="#" class="socials google" style="font-size:30px;" title="Google">G</a>
        <a href="#" class="socials linkedin" style="font-size:30px;" title="Linkedin">I</a>
        <a href="#" class="socials rss" style="font-size:30px;" title="Rss">R</a>
    </div>
</div>
</div>

<script type="text/javascript" src="js/jquery.custom.js"></script>
<script type="text/javascript" src="js/contact.js"></script>

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
</body>
</html>
