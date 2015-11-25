package ua.nure.lubchenko.st4.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.OrderDAO;
import ua.nure.lubchenko.st4.db.dao.SaleDAO;
import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.Order;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class ShowPersonalAccountAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		UserDAO udao = new UserDAO();
		OrderDAO odao = new OrderDAO();
		SaleDAO sdao = new SaleDAO();

		int userId = Integer.parseInt(request.getParameter("userId"));

		int ordersCounter = sdao.getNumberOfUserOrders(userId);
		int stepSale = sdao.getStepSale();
		int maxStepSale = sdao.getMaxStepSale();
		int personalSale = 0;
		if (stepSale * ordersCounter < maxStepSale) {
			personalSale = stepSale * ordersCounter;
		} else {
			personalSale = maxStepSale;
		}

		User user = udao.getUserById(userId);

		List<Order> orders = odao.getUserOrders(user.getIdUser());

		request.setAttribute("user", user);
		request.setAttribute("orders", orders);
		request.setAttribute("personalSale", personalSale);
		return Path.PERSONAL_ACCOUNT;

	}

}
