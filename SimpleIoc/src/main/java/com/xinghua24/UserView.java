package com.xinghua24;

public class UserView {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void displayUser(){
		User user = userService.getUser();
		user.display();
	}
}
