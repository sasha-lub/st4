package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.SaleDAO;
import ua.nure.lubchenko.st4.db.dao.TourDAO;
import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.Tour;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class ShowTourDetailsAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		SaleDAO sdao = new SaleDAO();
		
		String forward = Path.TOUR_PAGE;
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = new UserDAO().getUserById(userId);
		int tourId = Integer.parseInt(request.getParameter("tourId"));
		Tour tour = new TourDAO().getTourById(tourId);
		
		int ordersCounter = sdao.getNumberOfUserOrders(userId);
		int stepSale = sdao.getStepSale();
		int maxStepSale = sdao.getMaxStepSale();
		int personalSale;


		System.out.println(user.getLogin());
		if (stepSale * ordersCounter < maxStepSale) {
			personalSale = stepSale * ordersCounter;
		} else {
			personalSale = maxStepSale;
		}

		request.setAttribute("personalSale", personalSale);		
		request.setAttribute("user", user);
		request.setAttribute("tour", tour);
		return forward;
	}

}
