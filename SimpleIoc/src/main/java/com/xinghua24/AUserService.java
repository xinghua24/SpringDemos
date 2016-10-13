package com.xinghua24;

public class AUserService implements UserService {

	@Override
	public User getUser() {
		return new User("User A");
	}

}
