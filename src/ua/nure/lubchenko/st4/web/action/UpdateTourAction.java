package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.TourDAO;
import ua.nure.lubchenko.st4.entity.Tour;
import ua.nure.lubchenko.st4.web.Path;

public class UpdateTourAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		int tourId = Integer.parseInt(request.getParameter("tourId"));
		TourDAO tdao = new TourDAO();
		Tour tour = tdao.getTourById(tourId);
		request.setAttribute("tour", tour);
		String message = null;
		tour.setCountry(request.getParameter("country"));
		tour.setCity(request.getParameter("city"));
		tour.setHotel(request.getParameter("hotel"));
		tour.setTourType(request.getParameter("tourType"));
		tour.setHotelType(request.getParameter("hotelType"));
		tour.setCost(Integer.parseInt(request.getParameter("cost")));
		tour.setPeopleNumber(Integer.parseInt(request.getParameter("peopleNumber")));
		tour.setFromDate(AddNewTourAction.convertDate(request.getParameter("fromDate")));
		tour.setToDate(AddNewTourAction.convertDate(request.getParameter("toDate")));
		tour.setIsHot(AddNewTourAction.getCheckBoxMark(request, "isHot"));

		String forward = Path.TOUR_EDITING_PAGE ;
		if (tour.getCountry() == null || tour.getCity() == null || tour.getHotel() == null) {
			message = "Fields can not be empty";
			request.setAttribute("message", message);
			return forward;
		}
		tdao.editTour(tour);
		return Path.TOUR_PAGE;
	}
}
