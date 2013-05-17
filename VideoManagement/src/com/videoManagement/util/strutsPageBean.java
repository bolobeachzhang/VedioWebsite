
package com.videoManagement.util;

/** 
 * @ClassName: PageBean 
 * @Description: TODO(这个是用来action分页的javaBean) 
 * @author 张兵 【390125214@qq.com】
 * @date 2013-1-30 下午1:06:45 
 *  
 */
public class strutsPageBean {
	private int currentPage = 1 ;//当前页
	private int totlePages = 0;//总页数
	private int pageSize = 0;//每页显示的数据
	private int totleRows = 0;//总数据数
	private int startNum = 0 ;//开始记录（指的是数据库的offset 去掉前多少条记录）
	private int nextPage = 0;//下一页
	private int previousPage;//上一页
	private boolean hasNextPage = false ; //是否有下一页默认是false
	private boolean hasPreviousPage = false;//是否有上一页，默认为false
	//默认的构造函数
	public strutsPageBean(){}
	/**
	 * 执行分页的函数
	 * @param pageSize 每页显示的数据的个数
	 * @param currentPage 当前页
	 * @param totalRows 数据总数
	 * 
	 * */
	public  strutsPageBean getstrutsPageBean(int pageSize, int currentPage, int totleRows){
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totlePages = totleRows;
		//计算总页数
		if(totleRows%pageSize ==0){
			totlePages = totleRows/pageSize;
		}else {
			System.out.println(totleRows/pageSize);
			totlePages = totleRows/pageSize +1;
		}
		System.out.println("总页数"+totlePages);
		//当前页大于总页数，说明是最后一页
		if(currentPage>=totlePages){
			hasNextPage = false;
			currentPage = totlePages;
		}else {
			hasNextPage = true;
		}
		//如果当前页小于或者等于第一页，说明是第一页
		if(currentPage<=1){
			hasPreviousPage = false;
			currentPage = 1 ;
		}else {
			hasPreviousPage = true;
		}
		//开始记录
		startNum = (currentPage - 1) * pageSize;
		//下一页
        nextPage = currentPage + 1;
        System.out.println("总记录数"+totleRows);
        //如果下一页就是为总页数那么就是最后一页
        if(nextPage>=totlePages){
        	nextPage = totlePages;
        }
        //那么上一页就是当前页的前一页，那么就-1
		previousPage = currentPage - 1;
		//如果上一页就是<=1，那么上一页就是第一页
		if(previousPage<=1){
			previousPage = 1;
		}
		strutsPageBean strutsPageBean = new strutsPageBean(currentPage,
				totlePages, pageSize, 
				totleRows, startNum, nextPage, previousPage, 
				hasNextPage, hasPreviousPage);
		return  strutsPageBean;
	}
	public strutsPageBean(int currentPage, int totlePages, int pageSize,
			int totleRows, int startNum, int nextPage, int previousPage,
			boolean hasNextPage, boolean hasPreviousPage) {
		super();
		this.currentPage = currentPage;
		this.totlePages = totlePages;
		this.pageSize = pageSize;
		this.totleRows = totleRows;
		this.startNum = startNum;
		this.nextPage = nextPage;
		this.previousPage = previousPage;
		this.hasNextPage = hasNextPage;
		this.hasPreviousPage = hasPreviousPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotlePages() {
		return totlePages;
	}
	public void setTotlePages(int totlePages) {
		this.totlePages = totlePages;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotleRows() {
		return totleRows;
	}
	public void setTotleRows(int totleRows) {
		this.totleRows = totleRows;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
}
