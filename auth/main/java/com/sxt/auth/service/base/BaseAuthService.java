package com.sxt.auth.service.base;

import com.sxt.auth.base.constant.AuthDB;
import com.sxt.auth.model.UserMD;
import com.sxt.auth.utils.Sha1Utils;

/**
 *
 * 对外基础服务类
 *
 * Created by shixiaotian on 16/4/20.
 */
public class BaseAuthService {

    public static final BaseAuthService me = new BaseAuthService();

    // 登录验证-mysql数据库
    public boolean landFromDB(String username, String password) {


        String encodePassword = Sha1Utils.encode(password);

        String dbPassword = UserMD.me.get(AuthDB.user.password);

        return  false;

    }

    // 验签查询-mysql数据库
}
