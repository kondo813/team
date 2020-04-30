package jp.co.internous.smile.model.form;

import java.io.Serializable;


public class UserForm implements Serializable  {
	private static final long serialVersionUID = -6647705901854191070L;
	
	
	private String userName;
	
	private String password;
	
	private String familyName;
	
	private String firstName;
	
	private String familyNameKana;
	
	private String firstNameKana;
	
	private byte gender;
	
	private String newPassword;
	
	private String newPasswordConfirm;
	
	
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
	public String getFamilyName() {
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
	//newPassword
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	//newPasswordConfirm
	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}
	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}
	
}
