package com.wangid3.domain;


import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class Users {
	private String id;
	private String username;
	private String password;
	private String phone;
	
	@Override
	public String toString() {
		return "User [uid=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + "]";
	}

	
	
	
}
