package com.sxt.auth.model;

import com.jfinal.kit.StrKit;
import com.sxt.auth.base.constant.AuthDB;
import com.sxt.auth.model.base.BaseAuthModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 用户数据model
 *
 * Created by shixiaotian on 16/4/20.
 *
 */
public class UserMD extends BaseAuthModel<UserMD> {
    public static final UserMD me = new UserMD();

    /**
     *
     * 判断用户名是否存在
     *
     * @param username 用户名(账户)
     *
     * @return boolean
     *
     */
    public boolean hasUser(String username) {

        String sql = "select * from " + AuthDB.user.tableName
                + " where " + AuthDB.user.username + "= ?";

        // 从数据库查询用户
        List<UserMD> result = UserMD.me.find(sql, username);

        // 判断是否有这个用户
        if(true) {

            return true;

        } else {

            return false;

        }

    }
}
