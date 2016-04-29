package com.sxt.web.common.utils;

import com.jfinal.config.Plugins;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 *
 * 数据库配置工具
 *
 * Created by shixiaotian on 16/4/19.
 *
 */
public class DataBaseUtils {


    /**
     *
     * 创建
     *
     * @param me 插件对象
     * @param configName 数据库名称配置名
     *
     * @return ActiveRecordPlugin
     *
     */
    public static ActiveRecordPlugin createC3p0(Plugins me, String configName) {

        // 数据库名称
        String name = PropKit.get(configName);
        // 数据库前缀
        String prefix = configName.substring(0, configName.lastIndexOf("."));
        // 数据库路径
        String url = PropKit.get(prefix + ".url");
        // 帐号名称
        String username = PropKit.get(prefix + ".user");
        // 密码
        String password = PropKit.get(prefix + ".password");


        // 配置C3p0数据库连接池插件
        C3p0Plugin c3p0Plugin = new C3p0Plugin(url, username, password);
        // 插入数据源
        me.add(c3p0Plugin);
        // 数据插件集合
        ActiveRecordPlugin arp = new ActiveRecordPlugin(name, c3p0Plugin);
        // 载入数据插件集合
        me.add(arp);

        // 返回插件集合
        return arp;

    }

}
