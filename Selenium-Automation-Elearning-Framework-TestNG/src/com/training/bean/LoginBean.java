package com.training.bean;

public class LoginBean {
	private String userName;
	private String password;
	public String tName;
	public LoginBean() {
	}

	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}

	

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}


}
