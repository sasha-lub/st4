package ua.nure.lubchenko.st4.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {

	public abstract String perform(HttpServletRequest request, HttpServletResponse response);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
