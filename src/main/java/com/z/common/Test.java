package com.z.common;


public class Test {
	
	public static void main(String[] args) {
		
		Page page = new Page();
		page.setCurrentPage(5);
		page.setPageSize(5);
		
		page = PageUtil.createPage(page, 23);
		System.out.println(page);
		
	}

}
