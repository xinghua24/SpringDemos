package com.xinghua24;

public class BUserService implements UserService {

	@Override
	public User getUser() {
		return new User("User B");
	}

}
