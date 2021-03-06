package com.sxt.web.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBlog<M extends BaseBlog<M>> extends Model<M> implements IBean {

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
