package ua.nure.lubchenko.st4.web.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class ShowUserDetailsAction extends Action {

		@Override
		public String perform(HttpServletRequest request, HttpServletResponse response) {
			String userLogin= request.getParameter("userLoin");
			User user = new UserDAO().getUserByLogin(userLogin);
			request.setAttribute("user", user);
			return Path.USER_PAGE;
		}
	}
