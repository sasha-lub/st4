package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class DeleteUserAction extends Action{
	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		
		int userId = Integer.valueOf(request.getParameter("userId"));
		String forward = Path.SHOW_USERS_LIST_ACTION;
		
		UserDAO udao = new UserDAO();
		User user = udao.getUserById(userId);
		udao.deleteUser(user);
		
		return forward;
	}
}
