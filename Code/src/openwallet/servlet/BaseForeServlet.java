package openwallet.servlet;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import openwallet.dao.*;
import openwallet.util.Page;

public class BaseForeServlet extends HttpServlet{

	protected AddressDAO addressDAO = new AddressDAO();
	protected CategoryDAO categoryDAO = new CategoryDAO();
	protected CommentDAO commentDAO = new CommentDAO();
	protected OrdersDAO orderDAO = new OrdersDAO();
	protected ItemOrderDAO itemOrderDAO = new ItemOrderDAO();
	protected ProductDAO productDAO = new ProductDAO();
	protected UserDAO userDAO = new UserDAO();
	protected ItemCartDAO itemCartDAO = new ItemCartDAO();
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			int start= 0;
			int count = 10;
			try {
				start = Integer.parseInt(request.getParameter("page.start"));
			} catch (Exception e) {
				
			}
			
			try {
				count = Integer.parseInt(request.getParameter("page.count"));
			} catch (Exception e) {
			}
			
			Page page = new Page(start,count);
			
			String method = (String) request.getAttribute("method");

			Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class,Page.class);
			
			String redirect = m.invoke(this,request, response,page).toString();
			
			if(redirect.startsWith("@"))
				response.sendRedirect(redirect.substring(1));
			else if(redirect.startsWith("%"))
				response.getWriter().print(redirect.substring(1));
			else
				request.getRequestDispatcher(redirect).forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
