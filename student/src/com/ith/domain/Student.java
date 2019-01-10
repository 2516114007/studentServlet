package com.ith.domain;

public class Student {
	private int id;
	private String name;//����
	private String gender;//�Ա�
	private String phone;//�绰
	private String birthday;//��������
	private String hobby;//��Ȥ����
	private String info;//��ע
	public Student() {}
	public Student(String name, String gender, String phone, String birthday, String hobby, String info) {
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", birthday="
				+ birthday + ", hobby=" + hobby + ", info=" + info + "]";
	}
}
