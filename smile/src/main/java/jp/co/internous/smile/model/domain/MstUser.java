package jp.co.internous.smile.model.domain;

import java.sql.Timestamp;

import jp.co.internous.smile.model.form.UserForm;



public class MstUser {
	

	private int id;
	
	private String userName;
	
	private String password;
	
	private String familyName;
	
	private String firstName;
	
	private String familyNameKana;
	
	private String firstNameKana;
	
	private byte gender;
	
	private Timestamp created_at;
	
	private Timestamp updated_at;
	
	
	//constructor(初期値UserForm引用)
	public MstUser() {}
	
	public MstUser(UserForm f) {
		userName=f.getUserName();
		familyName=f.getFamilyName();
		firstName=f.getFirstName();
		familyNameKana=f.getFamilyNameKana();
		firstNameKana=f.getFirstNameKana();
		password=f.getPassword();
		gender=f.getGender();
	}
	
	
	//id
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	//userName
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getUserName() {
		return userName;
	}
	//password
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	//familyName
	public void setFamilyName(String familyName) {
		this.familyName=familyName;
	}
	public String getFamilyName(){
		return familyName;
	}
	//firstName
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	//familyNameKana
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana=familyNameKana;
	}
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	//firstNameKana
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana=firstNameKana;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	//gender
	public void setGender(byte gender) {
		this.gender=gender;
	}
	public byte getGender() {
		return gender;
	}
	//created_ut
	public void setCreated_at(Timestamp created_at) {
		this.created_at=created_at;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	//updated_at
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at=updated_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
}
