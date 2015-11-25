package ua.nure.lubchenko.st4.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.SaleDAO;
import ua.nure.lubchenko.st4.db.dao.TourDAO;
import ua.nure.lubchenko.st4.entity.Tour;
import ua.nure.lubchenko.st4.web.Path;

public class SelectSearchCriteriaAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		List<Tour> tours = null;
		TourDAO tdao = new TourDAO();
		SaleDAO sdao = new SaleDAO();
		int hotSale = sdao.getHotSale();
		request.setAttribute("hotSale", hotSale);
		String criteria = request.getParameter("criteria");
		switch (criteria) {
		case "allTours": {
			tours = tdao.getAllTours();
			break;
		}
		
		case "byType": {
			tours = tdao.searchByType(request.getParameter("tourType"));
			break;
		}
		
		case "byCost": {
			int minCost = Integer.parseInt(request.getParameter("minCost"));
			int maxCost = Integer.parseInt(request.getParameter("maxCost"));

			tours = tdao.searchByPrice(minCost, maxCost);
			break;
		}
		
		case "byHotelType": {
			tours = tdao.searchByHotelType(request.getParameter("hotelType"));
			System.out.println(criteria);

			break;
		}
		
		case "byPeopleNumber": {
			int peopleNum = Integer.parseInt(request.getParameter("peopleNumber"));
			System.out.println(peopleNum);

			tours = tdao.searchByNumberOfPeople(peopleNum);
			break;
		}
		}

		request.setAttribute("tours", tours);

		return Path.TOURS_LIST_PAGE;
	}
}
