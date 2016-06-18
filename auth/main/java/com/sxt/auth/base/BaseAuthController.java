package com.sxt.auth.base;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 权限系统基类controller
 *
 * Created by shixiaotian on 16/4/29.
 *
 */
public class BaseAuthController extends Controller {

    /**
     *
     * 返回简单成功报文
     *
     */
    public void renderSuccessJson() {


        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 200);
        resultMap.put("data", true);

        this.renderJson(resultMap);

    }

    /**
     *
     * 返回简单失败报文
     *
     * @param msg 失败信息
     */
    public void renderFailJson(String msg) {


        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 201);
        resultMap.put("data", msg);

        this.renderJson(resultMap);

    }

    /**
     *
     * 获取登录者ip
     *
     */
    public String getIp() {

        // 获取请求对象
        HttpServletRequest request = this.getRequest();
        // 获取ip
        String ip = request.getRemoteAddr();

        return ip;
    }
}
