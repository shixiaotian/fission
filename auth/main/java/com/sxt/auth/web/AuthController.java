package com.sxt.auth.web;

import com.sxt.auth.base.BaseAuthController;
import com.sxt.auth.model.UserMD;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 权限控制登陆器
 *
 * Created by shixiaotian on 16/4/29.
 */
public class AuthController extends BaseAuthController {

    /**
     *
     * 登录
     *
     */
    public void land() {

        // 获取前端传入参数
        String userCode = this.getPara("userCode");
        String password = this.getPara("password");

        // 查询数据信息
        boolean result = UserMD.me.checkPassword(userCode, password);

        // 构建返回结果集
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 200);
        resultMap.put("data", result);

        // 返回数据
        this.renderJson(resultMap);

    }

}
