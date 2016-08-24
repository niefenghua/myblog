package com.z.common;

public class Page {
	
	private int pageSize;
	private int currentPage;
	private int beginIndex;
	private int totalCount;
	private int totalPage;
	private boolean haspre;
	private boolean hasnext;
	
	public Page() {
	}

	public Page(int pageSize, int currentPage, int beginIndex, int totalCount, int totalPage, boolean haspre,
			boolean hasnext) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.haspre = haspre;
		this.hasnext = hasnext;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isHaspre() {
		return haspre;
	}

	public void setHaspre(boolean haspre) {
		this.haspre = haspre;
	}

	public boolean isHasnext() {
		return hasnext;
	}

	public void setHasnext(boolean hasnext) {
		this.hasnext = hasnext;
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", currentPage=" + currentPage + ", beginIndex=" + beginIndex
				+ ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", haspre=" + haspre + ", hasnext="
				+ hasnext + "]";
	}
	
	

	
}
