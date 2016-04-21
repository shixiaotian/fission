package com.sxt.web.common.model;

import com.jfinal.config.Plugins;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 *
 * 数据库映射接口
 * 在内部使用DataBaseUtils创建数据库链接对象
 * 然后编写映射即可
 *
 */
public interface MappingKit {

	/**
	 * 执行数据映射
	 *
	 * @param me
	 * @param configName 映射数据库配置名
	 *
     */
	public void mapping(Plugins me, String configName);

}

