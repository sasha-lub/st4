package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.lubchenko.st4.web.Path;

public class LogoutAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		return Path.LOGIN_PAGE;
	}
}
