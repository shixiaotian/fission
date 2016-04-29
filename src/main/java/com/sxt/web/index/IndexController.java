package com.sxt.web.index;

import com.jfinal.core.Controller;
import com.sxt.auth.model.UserMD;

/**
 * IndexController
 */
public class IndexController extends Controller {

	public void index() {

//		BaseAuthService.me.landFromDB();
//		boolean hasUser = UserMD.me.hasUser("bibijiang");
//		System.out.println(hasUser);
		// 检查密码
		boolean pass = UserMD.me.checkPassword("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "qweasd");
		System.out.println(pass);
		render("index.html");

	}

}





