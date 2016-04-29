package com.sxt.web.index;

import com.jfinal.core.Controller;
import com.sxt.auth.model.UserMD;
import com.sxt.auth.service.base.BaseAuthService;

/**
 * IndexController
 */
public class IndexController extends Controller {

	public void index() {

//		BaseAuthService.me.landFromDB();
		boolean hasUser = UserMD.me.hasUser("bibijiang");
		System.out.println(hasUser);
		render("index.html");

	}

}





