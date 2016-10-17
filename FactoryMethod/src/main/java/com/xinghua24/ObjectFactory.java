package com.xinghua24;

public class ObjectFactory {
	
	// getBar factory method should not be static!
	public Bar getBar(){
		Bar bar = new Bar();
		return bar;
	}
}
