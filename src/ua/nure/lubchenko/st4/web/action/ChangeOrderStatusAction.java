package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.OrderDAO;
import ua.nure.lubchenko.st4.entity.Order;
import ua.nure.lubchenko.st4.entity.Status;
import ua.nure.lubchenko.st4.web.Path;

public class ChangeOrderStatusAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		int tourId = Integer.parseInt(request.getParameter("tourId"));
		OrderDAO odao =  new OrderDAO();
		Order order = odao.getOrdersByUserIdAndTourId(userId, tourId);
		order.setStatus(Status.valueOf(request.getParameter("status").toUpperCase()));
		odao.updateOrder(order);
		return Path.SHOW_ORDERS_LIST_ACTION;
	}

}
