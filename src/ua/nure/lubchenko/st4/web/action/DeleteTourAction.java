package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.TourDAO;
import ua.nure.lubchenko.st4.entity.Tour;
import ua.nure.lubchenko.st4.web.Path;

public class DeleteTourAction extends Action{
	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		
		int tourId = Integer.valueOf(request.getParameter("tourId"));
	
		String forward = Path.SHOW_TOURS_LIST_ACTION;
		System.out.println("action delete tour");

		TourDAO tdao = new TourDAO();
		Tour tour = tdao.getTourById(tourId);
		tdao.deleteTour(tour);
		
		return forward;
	}
}
