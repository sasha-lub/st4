package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.SaleDAO;
import ua.nure.lubchenko.st4.web.Path;

public class ManageSalesAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		int stepSale = Integer.parseInt(request.getParameter("stepSale"));
		int hotSale = Integer.parseInt(request.getParameter("hotSale"));
		int maxStepSale = Integer.parseInt(request.getParameter("maxStepSale"));

		SaleDAO sdao = new SaleDAO();
		sdao.updateHotSale(hotSale);
		sdao.updateStepSale(stepSale);
		sdao.updateMaxStepSale(maxStepSale);
		return Path.ADMIN_PAGE;
	}

}
