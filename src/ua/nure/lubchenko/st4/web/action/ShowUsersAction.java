package ua.nure.lubchenko.st4.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class ShowUsersAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		List<User> users = new UserDAO().findUsers();
		request.setAttribute("users", users);
		return Path.USERS_LIST_PAGE;
	}
}
