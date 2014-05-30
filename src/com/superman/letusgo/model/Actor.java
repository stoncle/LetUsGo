package com.superman.letusgo.model;
/*
 * 活动者的模型，
 */
import com.superman.letusgo.base.BaseModel;


public class Actor extends BaseModel {
	
	// model columns
	public final static String COL_UID = "uid";
	public final static String COL_NAME = "name";
	public final static String COL_TOKEN = "token";
	public final static String COL_PWD = "pwd";
	
	public final static String COL_TEL = "tel";
	public final static String COL_SEX = "sex";
	public final static String COL_AGE = "age";
	public final static String COL_SMALL_AVATAR = "small_avatar";
	public final static String COL_BIG_AVATAR = "big_avatar";
	public final static String COL_LOC = "loc";
	
	private String uid;
	private String token;
	private String name;
	private String pwd;
	private String loc;
	private String tel;
	private String sex;
	private String age;
	private String small_avatar;
	private String big_avatar;
	
	// default is no login
	private boolean isLogin = false;
	
	// single instance for login
	static private Actor actor = null;
	
	static public Actor getInstance () {
		if (Actor.actor == null) {
			Actor.actor = new Actor();
		}
		return Actor.actor;
	}
	
	public Actor () {}
	
	public String getUId () {
		return this.uid;
	}
	
	public void setUid (String uid) {
		this.uid = uid;
	}
	
	public String getToken () {
		return this.token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	public String getPwd () {
		return this.pwd;
	}
	
	public void setPwd (String pwd) {
		this.pwd = pwd;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getLoc () {
		return this.loc;
	}
	
	public void setLoc (String loc) {
		this.loc = loc;
	}
	
	public String getTel () {
		return this.tel;
	}
	
	public void setTel (String tel) {
		this.tel = tel;
	}
	
	public String getSex () {
		return this.sex;
	}
	
	public void setSex (String sex) {
		this.sex = sex;
	}
	
	public String getSmallAvatar () {
		return this.small_avatar;
	}
	
	public void setSmallAvatar (String small_avatar) {
		this.small_avatar = small_avatar;
	}
	
	public String getBigAvatar () {
		return this.big_avatar;
	}
	
	public void setBigAvatar (String big_avatar) {
		this.big_avatar = big_avatar;
	}
	
	public String getAge () {
		return this.age;
	}
	
	public void setAge (String age) {
		this.age = age;
	}
	
	
	public Boolean getLogin () {
		return this.isLogin;
	}
	
	public void setLogin (boolean isLogin) {
		this.isLogin = isLogin;
	}
}