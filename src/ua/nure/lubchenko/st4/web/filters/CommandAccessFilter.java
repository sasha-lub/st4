package ua.nure.lubchenko.st4.web.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.nure.lubchenko.st4.entity.Roles;
import ua.nure.lubchenko.st4.web.Path;

public class CommandAccessFilter implements Filter {

	private Map<Roles, List<String>> accessMap = new HashMap<Roles, List<String>>();
	private List<String> commons = new ArrayList<String>();
	private List<String> outOfControl = new ArrayList<String>();

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (accessAllowed(request)) {
			chain.doFilter(request, response);
		} else {
			String errorMessasge = "You do not have permission to access the requested resource";

			request.setAttribute("errorMessage", errorMessasge);

			request.getRequestDispatcher(Path.ERROR_PAGE).forward(request, response);
		}
	}

	private boolean accessAllowed(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String commandName = request.getParameter("action");
		if (commandName == null || commandName.isEmpty()) {
			return false;
		}

		if (outOfControl.contains(commandName)) {
			return true;
		}

		HttpSession session = httpRequest.getSession(false);
		if (session == null) {
			return false;
		}

		Roles userRole = (Roles) session.getAttribute("userRole");
		if (userRole == null) {
			return false;
		}

		return accessMap.get(userRole).contains(commandName) || commons.contains(commandName);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// roles
		accessMap.put(Roles.ADMIN, asList(fConfig.getInitParameter("admin")));
		accessMap.put(Roles.MANAGER, asList(fConfig.getInitParameter("manager")));
		accessMap.put(Roles.CLIENT, asList(fConfig.getInitParameter("client")));

		// commons
		commons = asList(fConfig.getInitParameter("common"));

		// out of control
		outOfControl = asList(fConfig.getInitParameter("out-of-control"));
	}

	private List<String> asList(String str) {
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		System.out.println(list);
		return list;
	}
}
