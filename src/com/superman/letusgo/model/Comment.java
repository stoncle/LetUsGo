package com.superman.letusgo.model;

import com.superman.letusgo.base.BaseModel;

public class Comment extends BaseModel{

	// model columns
	public final static String COL_ID = "uid";
	public final static String COL_CONTENT = "content";
	public final static String COL_UPTIME = "uptime";
	
	private String uid;
	private String content;
	private String uptime;
	
	public Comment () {}
	
	public String getUId () {
		return this.uid;
	}
	
	public void setId (String uid) {
		this.uid = uid;
	}
	
	public String getContent () {
		return this.content;
	}
	
	public void setContent (String content) {
		this.content = content;
	}
	
	public String getUptime () {
		return this.uptime;
	}
	
	public void setUptime (String uptime) {
		this.uptime = uptime;
	}
}
