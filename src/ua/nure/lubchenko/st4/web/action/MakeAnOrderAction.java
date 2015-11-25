package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.OrderDAO;
import ua.nure.lubchenko.st4.entity.Order;
import ua.nure.lubchenko.st4.entity.Status;
import ua.nure.lubchenko.st4.web.Path;

public class MakeAnOrderAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {

		Order order = new Order();
		order.setIdTour(Integer.parseInt(request.getParameter("tourId")));
		order.setIdUser(Integer.parseInt(request.getParameter("userId")));
		order.setStatus(Status.REGISTERED);
		OrderDAO odao = new OrderDAO();
		odao.addOrder(order);		
		
		return Path.LOGIN_PAGE;
	}

}
