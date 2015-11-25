package ua.nure.lubchenko.st4.web.action;

import java.util.Map;
import java.util.TreeMap;
import static ua.nure.lubchenko.st4.web.action.ActionNames.*;

public class ActionContainer {
	private static Map<String, Action> container;
	
	static {
		container = new TreeMap<>();

		container.put(LOGIN_ACTION_NAME, new LoginAction());
		container.put(LOGOUT_ACTION_NAME, new LogoutAction());
		container.put(REGISTER_ACTION_NAME, new RegisterAction());
		container.put(SHOW_TOURS_ACTION_NAME, new ShowToursAction());
		container.put(SHOW_USERS_ACTION_NAME, new ShowUsersAction());
		container.put(DELETE_USER_ACTION_NAME, new DeleteUserAction());
		container.put(DELETE_TOUR_ACTION_NAME, new DeleteTourAction());
		container.put(ADD_NEW_TOUR_ACTION_NAME, new AddNewTourAction());
		container.put(MAKE_AN_ORDER_ACTION_NAME, new MakeAnOrderAction());
		container.put(GO_TO_ACCOUNT_ACTION_NAME, new GoToAccountAction());
		container.put(SHOW_TOUR_DETAILS_ACTION_NAME, new ShowTourDetailsAction());
		container.put(SHOW_USER_DETAILS_ACTION_NAME, new ShowUserDetailsAction());
		container.put(EDIT_TOUR_ACTION_NAME, new EditTourInfoAction());
		container.put(UPDATE_TOUR_ACTION_NAME, new UpdateTourAction());
		container.put(SHOW_ORDERS_ACTION_NAME, new ShowOrdersAction());
		container.put(BAN_USER_ACTION, new BanUnbanUserAction());
		container.put(UNBAN_USER_ACTION, new BanUnbanUserAction());
		container.put(CHANGE_ORDER_STATUS_ACTION, new ChangeOrderStatusAction());
		container.put(SHOW_PERSONAL_ACCOUNT_ACTION_NAME, new ShowPersonalAccountAction());
		container.put(MANAGE_SALES_ACTION, new ManageSalesAction());
		container.put(SELECT_SEARCH_CRITERIA_ACTION, new SelectSearchCriteriaAction());


		container.put(NONE_ACTION_NAME, new NoneAction());
	}
	
	public static Action getAction(String actionName){
		
		if (actionName != null && container.containsKey(actionName)){
			return container.get(actionName);
		} else {
			return container.get(NONE_ACTION_NAME);
		}
		
	}
}
