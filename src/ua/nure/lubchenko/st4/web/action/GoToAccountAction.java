package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.Roles;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class GoToAccountAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String forward = null;
		User user = new UserDAO().getUserById(userId);
		Roles userRole = Roles.getRole(user);
		switch (userRole) {
		case CLIENT:
			forward = Path.PERSONAL_ACCOUNT_ACTION;
			break;
		case MANAGER:
			forward = Path.MANAGER_PAGE;
			break;
		case ADMIN:
			forward = Path.ADMIN_PAGE;
			break;
		default:
			break;
		}
		return forward;
	}

}
