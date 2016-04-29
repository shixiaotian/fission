package com.sxt.auth.model;

import com.jfinal.kit.StrKit;
import com.sxt.auth.base.constant.AuthDB;
import com.sxt.auth.model.base.BaseAuthModel;
import com.sxt.auth.utils.ListUtils;
import com.sxt.auth.utils.Sha1Utils;

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
     * @param userCode 用户编码
     *
     * @return boolean
     *
     */
    public boolean hasUser(String userCode) {

        // 从数据库查询用户
        UserMD result = UserMD.me.getUserByUserCode(userCode);

        // 判断是否有这个用户
        if(result == null) {

            return false;

        } else {

            return true;

        }

    }

    /**
     *
     * 检查对应账号密码
     *
     * @param userCode 用户编码
     * @param password 密码
     *
     * @return
     */
    public boolean checkPassword(String userCode, String password) {

        // 传入参数为null 返回null
        if(StrKit.isBlank(userCode) || StrKit.isBlank(password)) {
            return false;
        }

        // 查询到用户
        UserMD userMD = UserMD.me.getUserByUserCode(userCode);

        // 未能查询到返回null
        if(userMD == null) {
            return false;
        }

        // 对传入的密码sha1
        String afterSha1Password = Sha1Utils.encode(password);
        // 获得数据库中密码
        String dbPassword = userMD.get(AuthDB.user.password);

        // 比对密码是否相同
        if(afterSha1Password.equals(dbPassword)) {

            return true;

        } else {

            return false;

        }


    }

    /**
     *
     * 获取用户数据
     *
     * 从数据库查询(组合查询)
     *
     * @param userCode 用户编码
     *
     * @return
     */
    public UserMD getUserByUserCode(String userCode) {

        // 查询sql
        String sql =
                "select * from "
                        + AuthDB.user.tableName
                        + " where "
//                        + AuthDB.user.lock + "=0"
//                        + " and " + AuthDB.user.deleted + "=0"
//                        + " and " +
                        + AuthDB.user.userCode + "= ?"
                ;

        // 从数据库查询用户
        List<UserMD> userMDList = UserMD.me.find(sql, userCode);

        // 判断是否查询到数据
        if(ListUtils.isEmpty(userMDList)) {

            return null;

        } else {

            // 获取第一个(注:唯一一个)
            UserMD result = userMDList.get(0);

            return result;
        }

    }

    /**
     *
     * 获取用户数据
     *
     * 从redis查询
     * 1.尽量只从这个地方查询,用户有新增登录信息,在新增的地方进行动态补充
     * 2.如果没有找到用户,则从数据库中查询
     * 3.用户注销.或者删除,需要主动从redis中清除
     *
     * @param userMD 用户数据
     *
     * @return
     */
    public List<UserMD> getUserFromRedis(UserMD userMD) {
        return null;
    }

}
