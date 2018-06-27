package com.libo.libo.admin;

public class Admin {
	private String id;
	private String password;
	private String nickname;
	private String birthday;
	private String gender;
	
	public Admin() {
		
	}
	
	public Admin(String id, String password, String nickname, String birthday, String gender) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + ", nickname=" + nickname + ", birthday=" + birthday
				+ ", gender=" + gender + "]";
	}
	
}
