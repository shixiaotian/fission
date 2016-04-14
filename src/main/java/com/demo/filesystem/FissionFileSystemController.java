package com.demo.filesystem;

import com.demo.common.model.FissionFileSystem;
import com.demo.filesystem.FissionFileSystemInterceptor;
import com.demo.filesystem.FissionFileSystemValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * FissionFissionFileSystemController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(FissionFileSystemInterceptor.class)
public class FissionFileSystemController extends Controller {
	public void index() {
//		setAttr("FissionFileSystemPage",
		Page<FissionFileSystem> result = FissionFileSystem.me.paginate(getParaToInt(0, 1), 10);

		renderJson(result);
	}
	
	public void add() {
	}
	
	@Before(FissionFileSystemValidator.class)
	public void save() {
		getModel(FissionFileSystem.class).save();
		redirect("/FissionFileSystem");
	}
	
	public void edit() {
		setAttr("FissionFileSystem", FissionFileSystem.me.findById(getParaToInt()));
	}
	
	@Before(FissionFileSystemValidator.class)
	public void update() {
		getModel(FissionFileSystem.class).update();
		redirect("/FissionFileSystem");
	}
	
	public void delete() {
		FissionFileSystem.me.deleteById(getParaToInt());
		redirect("/FissionFileSystem");
	}
}


