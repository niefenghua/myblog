package com.z.common;

public class PageUtil {

	public static Page createPage(int pageSize,int currentPage,int totalCount){
		pageSize = getPageSize(pageSize);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(pageSize, totalCount);
		int beginIndex = getBeginIndex(pageSize, currentPage);
		boolean haspre = isHaspre(currentPage);
		boolean hasnext = isHasnext(totalPage, currentPage);
		return new Page(pageSize, currentPage, beginIndex, totalCount, totalPage, haspre, hasnext);
	}
	public static Page createPage(Page page,int totalCount) {
		int pageSize = getPageSize(page.getPageSize());
		int currentPage = getCurrentPage(page.getCurrentPage());
		int totalPage = getTotalPage(pageSize, totalCount);
		int beginIndex = getBeginIndex(pageSize, currentPage);
		boolean haspre = isHaspre(currentPage);
		boolean hasnext = isHasnext(totalPage, currentPage);
		return new Page(pageSize, currentPage, beginIndex, totalCount, totalPage, haspre, hasnext);
	}
	public static int getPageSize(int pageSize) {
		return pageSize==0?10:pageSize;
	}
	public static int getCurrentPage(int currentPage) {
		return currentPage==0?1:currentPage;
	}
	public static int getTotalPage(int pageSize,int totalCount) {
		int totalPage = 0;
		if(totalCount%pageSize ==0){
			totalPage = totalCount/pageSize;
		}else {
			totalPage = totalCount/pageSize + 1;
		}
		return totalPage;
	}
	public static int getBeginIndex(int pageSize,int currentPage) {
		return (currentPage-1)*pageSize;
	}
	public static boolean isHaspre(int currentPage) {
		return currentPage==1?false:true;
	}
	
	public static boolean isHasnext(int totalPage,int currentPage) {
		return currentPage==totalPage || totalPage==1?false:true;
	}
	
}
