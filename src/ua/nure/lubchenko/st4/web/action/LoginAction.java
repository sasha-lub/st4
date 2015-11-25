package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.Roles;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class LoginAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String message = null;
		String forward = Path.LOGIN_PAGE;

		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			message = "Password and/or login cannot be empty";
			request.setAttribute("message", message);
			return forward;
		}
		User user = new UserDAO().getUserByLogin(login);

		HttpSession session = request.getSession();

		if (user == null || !password.equals(user.getPassword())) {
			message = "User with such login/password not founded";
			request.setAttribute("message", message);
			forward = Path.LOGIN_PAGE;
		} else {
			Roles userRole = Roles.getRole(user);
			switch (userRole) {
			case CLIENT:
				forward = Path.SHOW_TOURS_LIST_ACTION;
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
			session.setAttribute("user", user);
			session.setAttribute("fullName", user.getFullName());
			session.setAttribute("userRole", userRole);
		}
		return forward;
	}
}
