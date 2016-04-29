package com.sxt.auth.base;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

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
}
