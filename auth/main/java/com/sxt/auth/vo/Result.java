package com.sxt.auth.vo;

/**
 *
 *  返回结果集合
 *
 * Created by xiaotian.shi on 2016/6/18.
 */
public class Result {

    // 编码
    private String code;

    // 信息内容
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
