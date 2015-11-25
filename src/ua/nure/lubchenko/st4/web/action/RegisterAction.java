package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class RegisterAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {

		String login = request.getParameter("login");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String fullName = request.getParameter("fullName");
		String message = null;
		String forward = Path.LOGIN_PAGE;
		if (!password1.equals(password2)) {
			message = "Passwords are not equal";
			System.out.println(message);

			request.setAttribute("message", message);
			forward = Path.REGISTRATION_PAGE;
			return forward;
		}

		String password = password1;

		if (login == null || password == null || fullName == null || login.isEmpty() || password.isEmpty()
				|| fullName.isEmpty()) {
			message = "Fields can not be empty";
			request.setAttribute("message", message);
			forward = Path.REGISTRATION_PAGE;
			return forward;
		}

		UserDAO udao = new UserDAO();

		if (udao.getUserByLogin(login) != null) {
			message = "Login is already in use";
			System.out.println(message);
			request.setAttribute("message", message);
			forward = Path.REGISTRATION_PAGE;
			return forward;
		}

		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setFullName(fullName);
		user.setIdRole(2);
		user.setBanned(false);

		udao.addUser(user);
		message = "Registration succesfull";

		return forward;
	}
}
