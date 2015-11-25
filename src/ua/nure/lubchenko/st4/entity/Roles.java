package ua.nure.lubchenko.st4.entity;

public enum Roles {

		ADMIN, MANAGER, CLIENT;
		
		public static Roles getRole(User user) {
			int roleId = user.getIdRole();
			return Roles.values()[roleId];
		}
		
		public String getName() {
			return name().toLowerCase();
		}
		
	
}
