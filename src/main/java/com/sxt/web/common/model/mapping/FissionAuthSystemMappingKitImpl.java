package com.sxt.web.common.model.mapping;

import com.sxt.auth.base.constant.AuthDB;
import com.sxt.auth.model.UserMD;
import com.sxt.web.common.model.MappingKit;
import com.sxt.web.common.utils.DataBaseUtils;
import com.jfinal.config.Plugins;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 *
 * 权限系统数据库映射
 *
 * Created by shixiaotian on 16/4/20.
 *
 */
public class FissionAuthSystemMappingKitImpl implements MappingKit {


    public FissionAuthSystemMappingKitImpl(Plugins me, String configName) {

        this.mapping(me, configName);

    }

    public void mapping(Plugins me, String configName) {

        // 创建数据库链接映射对象
        ActiveRecordPlugin arp = DataBaseUtils.createC3p0(me, "fission.authsystem.db.name");
        // 映射
        arp.addMapping("user", AuthDB.user.userCode, UserMD.class);

    }

}
