package com.superman.letusgo.base;

import com.superman.letusgo.model.Actor;

public class BaseAuth {
	
	static public boolean isLogin () {
		Actor actor = Actor.getInstance();
		if (actor.getLogin() == true) {
			return true;
		}
		return false;
	}
	
	static public void setLogin (Boolean status) {
		Actor actor = Actor.getInstance();
		actor.setLogin(status);
	}
	
	static public void setActor (Actor ac) {
		Actor actor = Actor.getInstance();
		actor.setUid(ac.getUId());
		actor.setToken(ac.getToken());
		actor.setName(ac.getName());
		actor.setAge(ac.getAge());
		actor.setSex(ac.getSex());
		actor.setBigAvatar(ac.getBigAvatar());
		actor.setSmallAvatar(ac.getSmallAvatar());
		actor.setLoc(ac.getLoc());
		actor.setTel(ac.getTel());
		
	}
	
	static public Actor gerActor () {
		return Actor.getInstance();
	}
}