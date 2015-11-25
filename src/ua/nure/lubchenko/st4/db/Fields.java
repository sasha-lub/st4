package ua.nure.lubchenko.st4.db;

/**
 * Holder for fields names of DB tables and beans.
 * 
 * @author Lubchenko
 */
public final class Fields {
	
	// entities
	public static final String USER_ID = "id_user";
	public static final String USER_LOGIN = "login";
	public static final String USER_PASSWORD = "password";
	public static final String USER_FULL_NAME = "full_name";
	public static final String USER_BANNED = "banned";
	public static final String USER_ROLE_ID = "role_id";

	public static final String TOUR_ID = "id_tour";
	public static final String TOUR_COUNTRY = "country";
	public static final String TOUR_CITY = "city";
	public static final String TOUR_HOTEL = "hotel";
	public static final String TOUR_HOTEL_TYPE = "type_hotel";
	public static final String TOUR_TYPE = "type_trip";
	public static final String TOUR_COST = "cost";
	public static final String TOUR_PEOPLE_NUMBER = "people_number";
	public static final String TOUR_FROM_DATE = "from_date";
	public static final String TOUR_TO_DATE = "to_date";
	public static final String TOUR_IS_HOT = "hot";

	public static final String ORDER_USER_ID = "id_user";
	public static final String ORDER_TOUR_ID = "id_tour";
	public static final String ORDER_STATUS = "status";
	
	public static final String SALES_HOT_SALE = "hot_sale";
	public static final String SALES_STEP_SALE = "step_sale";
	public static final String SALES_MAX_STEP_SALE = "max_step_sale";
	
	public static final String NUMBER_OF_ORDERS = "NumberOfOrders";
	
	
//	// beans
//	public static final String USER_ORDER_BEAN_ORDER_ID = "id";	
//	public static final String USER_ORDER_BEAN_USER_FIRST_NAME = "first_name";	
//	public static final String USER_ORDER_BEAN_USER_LAST_NAME = "last_name";	
//	public static final String USER_ORDER_BEAN_ORDER_BILL = "bill";	
//	public static final String USER_ORDER_BEAN_STATUS_NAME = "name";
	
}