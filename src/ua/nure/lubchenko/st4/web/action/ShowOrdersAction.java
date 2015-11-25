package ua.nure.lubchenko.st4.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.OrderDAO;
import ua.nure.lubchenko.st4.entity.Order;
import ua.nure.lubchenko.st4.web.Path;

public class ShowOrdersAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		OrderDAO odao = new OrderDAO();

		List<Order> orders = odao.getAllOrders();
		request.setAttribute("orders", orders);

		return Path.ORDERS_LIST_PAGE;
	}
}
