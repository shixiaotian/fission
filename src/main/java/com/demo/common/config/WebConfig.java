package com.demo.common.config;

import com.demo.blog.BlogController;
import com.demo.common.model.MappingKit;
import com.demo.index.IndexController;
import com.demo.filesystem.FissionFileSystemController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * API引导式配置
 */
public class WebConfig extends JFinalConfig {
	
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("a_little_config.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		// 关闭action report
		me.setReportAfterInvocation(false);
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
	 *
	 * 开启demo数据库新的链接
	 *
	 * @return
     */
	public static C3p0Plugin createC3p0Plugin() {
		return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}

	/**
	 *
	 * 开启裂变文件系统数据库链接
	 * 新创建
	 *
	 * @return C3p0Plugin
     */
	public static C3p0Plugin createFissionFileSystemPlugin() {
		return new C3p0Plugin(PropKit.get("fission_filesystem"), PropKit.get("user"), PropKit.get("password").trim());
	}
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {

		// 配置C3p0数据库连接池插件
		C3p0Plugin demoC3p0Plugin = createC3p0Plugin();
		me.add(demoC3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin("demo",demoC3p0Plugin);
		me.add(arp);
		// 映射数据到model
		MappingKit.mappingDemoDB(arp);

		// 配置裂变文件系统c3p0数据库链接
		C3p0Plugin fissionFileSystemC3p0Plugin = createFissionFileSystemPlugin();
		me.add(fissionFileSystemC3p0Plugin);
		// 配置返回集合
		ActiveRecordPlugin fileSystemArp = new ActiveRecordPlugin("fissionFileSystem",fissionFileSystemC3p0Plugin);
		me.add(fileSystemArp);
		// 映射数据到model
		MappingKit.mappingFissionFilesystemDB(fileSystemArp);
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
}
