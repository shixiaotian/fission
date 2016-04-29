package com.sxt.auth.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 *
 * 权限系统Model基类
 *
 * Created by shixiaotian on 16/4/20.
 */
public class BaseAuthModel <M extends BaseAuthModel<M>> extends Model<M> implements IBean {

    public void setId(Integer id) {
        set("id", id);
    }

    public Integer getId() {
        return get("id");
    }

    public void setTitle(String title) {
        set("title", title);
    }

    public String getTitle() {
        return get("title");
    }

    public void setContent(String content) {
        set("content", content);
    }

    public String getContent() {
        return get("content");
    }

}
