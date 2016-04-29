package com.sxt.web.common.model.mapping;

import com.sxt.web.common.model.FissionFileSystem;
import com.sxt.web.common.model.MappingKit;
import com.sxt.web.common.utils.DataBaseUtils;
import com.jfinal.config.Plugins;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 *
 * 文件系统数据库映射
 *
 * Created by shixiaotian on 16/4/20.
 *
 */
public class FissionFileSystemMappingKitImpl implements MappingKit {

    public FissionFileSystemMappingKitImpl(Plugins me, String configName) {

        this.mapping(me, configName);

    }

    public void mapping(Plugins me, String configName) {

        // 创建数据库链接映射对象
        ActiveRecordPlugin arp = DataBaseUtils.createC3p0(me, "fission.filesystem.db.name");
        // 映射
        arp.addMapping("file", "fileId", FissionFileSystem.class);

    }

}
