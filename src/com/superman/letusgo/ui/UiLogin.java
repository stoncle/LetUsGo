package com.superman.letusgo.ui;

import java.util.Date;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.superman.letusgo.R;
import com.superman.letusgo.base.BaseAuth;
import com.superman.letusgo.base.BaseMessage;
import com.superman.letusgo.base.BaseUi;
import com.superman.letusgo.base.C;
import com.superman.letusgo.model.Actor;
import com.superman.letusgo.util.AppUtil;

public class UiLogin extends BaseUi implements OnClickListener {
	private Button submitBtn;
	private Button registerBtn;
	private Button findPassWordBtn;

	private EditText mEditAccount;// account
	private EditText mEditPwd;// password

	private SharedPreferences settings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// check if login
		if (BaseAuth.isLogin()) {
			this.forward(UiMain.class);
		}

		this.setContentView(R.layout.ui_login);

		submitBtn = (Button) this.findViewById(R.id.login_btn_submit);
		registerBtn = (Button) this
				.findViewById(R.id.login_btn_register);
		findPassWordBtn = (Button) this
				.findViewById(R.id.login_btn_getpassword);

		submitBtn.setOnClickListener(this);
		registerBtn.setOnClickListener(this);
		findPassWordBtn.setOnClickListener(this);

		mEditAccount = (EditText) findViewById(R.id.login_edittext_account);
		mEditPwd = (EditText) findViewById(R.id.login_edittext_password);
		mEditAccount.setText("13260614509");
		mEditPwd.setText("123");
		settings = getPreferences(Context.MODE_PRIVATE);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn_submit:
			forward(UiMain.class);
//			doTaskLogin();
			break;
		case R.id.login_btn_register:
			registerBtn.setVisibility(View.VISIBLE);

			break;
		case R.id.login_btn_getpassword:
			break;
		default:
			break;
		}
	}

	@SuppressLint("SimpleDateFormat")
	private void doTaskLogin() {
		// 父类中的app
		// 获取当前时间
		Date curDate = new Date(System.currentTimeMillis());
		long currentTime = curDate.getTime() / 1000;
		app.setLong(curDate.getTime());// 设置app的登陆时间

		if (mEditAccount.length() > 0 && mEditPwd.length() > 0) {
			HashMap<String, String> urlParams = getUrlParams(currentTime);
			try {
				this.doTaskAsync(C.task.login, C.api.login,
						urlParams);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 设置post方式下的一些传递的参数
	 */
	private HashMap<String, String> getUrlParams(Long currentTime) {
		HashMap<String, String> urlParams = new HashMap<String, String>();
		String accountTel = mEditAccount.getText().toString();
		String pwd = mEditPwd.getText().toString();
		String tel = accountTel;// post参数
		String pwdMd5 = AppUtil.md5(pwd);// 密码md5加密
		StringBuilder info = new StringBuilder();// 字符串拼接提高效率
		info.append(accountTel).append(":").append(pwdMd5).append(":")
				.append(currentTime.toString());
		urlParams.put("tel", tel);
		urlParams.put("info", AppUtil.md5(info.toString()));
		urlParams.put("dd", currentTime.toString());
		return urlParams;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////
	// async task callback methods

	@Override
	public void onTaskComplete(int taskId, BaseMessage message) {
		super.onTaskComplete(taskId, message);

		switch (taskId) {
		case C.task.login:
			Actor actor = null;
			// login logic
			try {
				actor = (Actor) message.getResult("Actor");
				// login success
				if (actor.getName() != null) {
					BaseAuth.setActor(actor);
					BaseAuth.setLogin(true);
					toast("login success");
				} else {// login fail
					BaseAuth.setActor(actor); // set
					BaseAuth.setLogin(false);
					toast(this.getString(R.string.msg_loginfail));
				}
			} catch (Exception e) {
				e.printStackTrace();
				toast(e.getMessage());
			}
			// login complete
			long startTime = app.getLong();
			long loginTime = System.currentTimeMillis() - startTime;
			Log.w("LoginTime", Long.toString(loginTime));
			// turn to index
			if (BaseAuth.isLogin()) {
				// start service
				// BaseService.start(this, NoticeService.class);
				// turn to index
				forward(UiMain.class);
			}
			break;
		}
	}
}
