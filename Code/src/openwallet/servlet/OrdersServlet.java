package openwallet.servlet;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import openwallet.bean.Orders;
import openwallet.dao.OrdersDAO;
import openwallet.util.Page;

public class OrdersServlet extends BaseBackServlet {

	
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}

	
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}
	public String delivery(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Orders o = ordersDAO.get(id);
		o.setDelivery_date(new Date());
		o.setStatus(OrdersDAO.waitConfirm);
		ordersDAO.update(o);
		return "@admin_orders_list";
	}

	
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;	
	}

	
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}

	
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		List<Orders> os = ordersDAO.list(page.getStart(),page.getCount());
		itemOrderDAO.fill(os);
		int total_number = ordersDAO.getTotal();
		page.setTotal(total_number);
		
		request.setAttribute("os", os);
		request.setAttribute("page", page);
		
		return "admin/listOrders.jsp";
	}
}
