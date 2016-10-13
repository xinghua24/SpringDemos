package com.xinghua24;

public class UserView {
	private UserService userService;
	
	public UserView(UserService userService) {
		this.userService = userService;
	}

	public void displayUser(){
		User user = userService.getUser();
		user.display();
	}
}
