package com.sxt.web.common.config;

import com.sxt.web.blog.BlogController;
import com.sxt.web.common.model.mapping.DemoMappingKitImpl;
import com.sxt.web.common.model.mapping.FissionAuthSystemMappingKitImpl;
import com.sxt.web.common.model.mapping.FissionFileSystemMappingKitImpl;
import com.sxt.web.index.IndexController;
import com.sxt.web.filesystem.FissionFileSystemController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;

/**
 * API引导式配置
 */
public class WebConfig extends JFinalConfig {
	
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {

		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("config.ini");

		//开发模式
		me.setDevMode(false);
		// 关闭action report
//		me.setReportAfterInvocation(false);
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/", IndexController.class, "/index");	// 第三个参数为该Controller的视图存放路径
		me.add("/blog", BlogController.class);
		me.add("/fissionFileSystem", FissionFileSystemController.class);	// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
	}

	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {

		// 初始化数据库插件
		initDateBasePlugin(me);

	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		
	}
	
	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 */
//	public static void main(String[] args) {
//		JFinal.start("web", 8080, "/", 1);
//	}


	// 初始化数据库
	private void initDateBasePlugin(Plugins me) {

		// demo数据库
		new DemoMappingKitImpl(me, "jfinal.demo.db.name");

		// 文件系统
		new FissionFileSystemMappingKitImpl(me, "fission.filesystem.db.name");

		//权限系统
		new FissionAuthSystemMappingKitImpl(me, "fission.authsystem.db.name");


	}


}
