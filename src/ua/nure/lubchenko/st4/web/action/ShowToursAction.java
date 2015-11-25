package ua.nure.lubchenko.st4.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.SaleDAO;
import ua.nure.lubchenko.st4.db.dao.TourDAO;
import ua.nure.lubchenko.st4.entity.Tour;
import ua.nure.lubchenko.st4.web.Path;

public class ShowToursAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		List<Tour> tours = new TourDAO().getAllTours();
		
		SaleDAO sdao = new SaleDAO();
		int hotSale = sdao.getHotSale();
				
		request.setAttribute("tours", tours);
		request.setAttribute("hotSale", hotSale);

		return Path.TOURS_LIST_PAGE;
	}
}
