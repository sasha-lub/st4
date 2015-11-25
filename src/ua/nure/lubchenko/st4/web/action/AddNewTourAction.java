package ua.nure.lubchenko.st4.web.action;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.TourDAO;
import ua.nure.lubchenko.st4.entity.Tour;
import ua.nure.lubchenko.st4.web.Path;

public class AddNewTourAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String hotel = request.getParameter("hotel");
		String tourType = request.getParameter("tourType");
		String hotelType = request.getParameter("hotelType");
		int cost = Integer.parseInt(request.getParameter("cost"));
		int peopleNumber = Integer.parseInt(request.getParameter("peopleNumber"));
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		boolean isHot = getCheckBoxMark(request, "isHot");
		String message = null;
		String forward = Path.ADMIN_PAGE;

		if (country == null || city == null || hotel == null) {
			message = "Fields can not be empty";
			request.setAttribute("message", message);
			forward = Path.ADD_NEW_TOUR;
			return forward;
		}
		TourDAO tdao = new TourDAO();
		Tour tour = new Tour();
		tour.setCountry(country);
		tour.setCity(city);
		tour.setHotel(hotel);
		tour.setHotelType(hotelType);
		tour.setTourType(tourType);
		tour.setCost(cost);
		tour.setPeopleNumber(peopleNumber);
		tour.setFromDate(convertDate(fromDate));
		tour.setToDate(convertDate(toDate));
		tour.setIsHot(isHot);
		tdao.addTour(tour);
		message = "Tour added successfully";
		request.setAttribute("message", message);

		return forward;
	}

	static Date convertDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return Date.from(LocalDate.parse(date, formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	static boolean getCheckBoxMark(HttpServletRequest request, String paramName) {
		boolean mark = false;
		try {
			if (request.getParameterValues(paramName)[0].equals("on")) {
				mark = true;
			}
		} catch (NullPointerException e) {
			mark = false;
		}
		return mark;
	}
}
