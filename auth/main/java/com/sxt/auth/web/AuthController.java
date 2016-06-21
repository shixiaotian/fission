package com.sxt.auth.web;

import com.jfinal.kit.StrKit;
import com.sxt.auth.base.BaseAuthController;
import com.sxt.auth.model.UserMD;
import com.sxt.auth.vo.Result;

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
        String ip =this.getIp();

        // 参数校验
        if(this.validation(userCode, password)) {
            return;
        }

        // 查询数据信息
        Result result = UserMD.me.checkPassword(userCode, password, ip);

        // 返回数据
        this.renderJson(result);

    }

    // 参数校验
    private boolean validation(String userCode, String password){
        // 传入参数为null 返回null
        if(StrKit.isBlank(userCode) || StrKit.isBlank(password)) {

            // 输出信息
            this.renderFailJson("账号和密码不能为空！");

            return true;
        }
        return false;
    }

}
