package com.bo;

public class AdminBo {
	
	private String adminemail;
	private String adminpassword;
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public AdminBo(String adminemail, String adminpassword) {
		super();
		this.adminemail = adminemail;
		this.adminpassword = adminpassword;
	}
	public AdminBo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
