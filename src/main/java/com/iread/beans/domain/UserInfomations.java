package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: UserInfomations
 *类描述:  用户的详细信息，包含用户的身份（职业）、昵称、头像、性别、自我介绍等
 *创建人: Administrator
 *创建时间: 2017年12月19日下午6:26:11
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class UserInfomations {
	
	private Integer id;
	private String nickName;
	private String imageUri;
	private String gender;
	private String aboutMe;
	private UserIdentify iden;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getImageUri() {
		return imageUri;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public UserIdentify getIden() {
		return iden;
	}
	public void setIden(UserIdentify iden) {
		this.iden = iden;
	}
	
}
