package com.statemanager;

public class User {
	
	String id;
	String name;
	Boolean sumAccess;
	public Boolean getSumAccess() {
		return sumAccess;
	}
	public void setSumAccess(Boolean sumAccess) {
		this.sumAccess = sumAccess;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
