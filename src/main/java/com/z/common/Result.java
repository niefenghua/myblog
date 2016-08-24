package com.z.common;

import java.util.List;

public class Result {
	private Page page;
	private List list;
	public void setList(List list) {
		this.list = list;
	}
	public List getList() {
		return list;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Page getPage() {
		return page;
	}

}
