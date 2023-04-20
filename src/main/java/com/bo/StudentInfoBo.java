package com.bo;

public class StudentInfoBo {
	
	private int id;
	private String fullName;
	private String email;
	private String dob;
	private String phone;
	private String subject;
	private String idType;
	private String idNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public StudentInfoBo(String fullName, String email, String dob, String phone, String subject, String idType,
			String idNumber) {
		super();
		
		this.fullName = fullName;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.subject = subject;
		this.idType = idType;
		this.idNumber = idNumber;
	}
	
	
	public StudentInfoBo(int id, String fullName, String email, String dob, String phone, String subject, String idType,
			String idNumber) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.subject = subject;
		this.idType = idType;
		this.idNumber = idNumber;
	}
	public StudentInfoBo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
