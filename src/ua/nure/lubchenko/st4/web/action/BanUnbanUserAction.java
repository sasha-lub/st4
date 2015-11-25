package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.lubchenko.st4.db.dao.UserDAO;
import ua.nure.lubchenko.st4.entity.User;
import ua.nure.lubchenko.st4.web.Path;

public class BanUnbanUserAction extends Action {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		System.out.println(action);
		UserDAO udao =  new UserDAO();
		User user = udao.getUserById(Integer.parseInt(request.getParameter("userId")));
		System.out.println(user);
		if(action.equals("banUser")){
			user.setBanned(true);
		}else {
			user.setBanned(false);
		}
		System.out.println(user);
		udao.updateUser(user);
		return Path.SHOW_USER_DETAILS_ACTION;
	}

}
