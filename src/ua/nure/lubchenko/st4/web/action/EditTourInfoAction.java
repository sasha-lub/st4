package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.TourDAO;
import ua.nure.lubchenko.st4.entity.Tour;
import ua.nure.lubchenko.st4.web.Path;

public class EditTourInfoAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		int tourId = Integer.parseInt(request.getParameter("tourId"));
		TourDAO tdao = new TourDAO();
		Tour tour = tdao.getTourById(tourId);
		request.setAttribute("tour", tour);
		return Path.TOUR_EDITING_PAGE;
	}
}
