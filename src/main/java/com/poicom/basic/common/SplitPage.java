package com.poicom.basic.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页封装，
 * 当前页数据-list，
 * 当前第n页-pageNumber，总共N页-totalPage，
 * 每页m条-currentPageCount，总共M条-totalRow，
 * 是否第一页-isFirst、是否最后一页-isLast、
 * 
 * 分页查询条件-queryParam、排序条件-orderColumn、排序方式-orderMode
 * 
 * @author FireTercel 2015年5月27日 
 *
 */
public class SplitPage implements Serializable {

	private static final long serialVersionUID = 2626134889810843260L;
	
	/**
	 * 分页查询参数
	 */
	private Map<String, String> queryParam;// 查询条件
	private String orderColunm;// 排序条件
	private String orderMode;// 排序方式
	private int pageNumber = DictKeys.default_pageNumber;// 第几页
	private int pageSize = DictKeys.default_pageSize;// 每页显示几多
	
	/**
	 * 分页结果的数据
	 */
	private List<?> list; // 当前页数据
	private int totalPage; // 总页数
	private int totalRow; // 总行数

	/**
	 * 分页显示辅助属性
	 */
	private int currentPageCount;// 当前页记录数量
	private boolean isFirst;// 是否第一页
	private boolean isLast;// 是否最后一页
	
	/**
	 * 分页计算
	 */
	public void compute() {
		if(totalRow == 0){
			getTotalPage();
		}
		
		this.currentPageCount = (null != this.list ? this.list.size() : 0);// 当前页记录数

		if (pageNumber == 1) {
			this.isFirst = true;
		} else {
			this.isFirst = false;
		}

		if (pageNumber == totalPage) {
			this.isLast = true;
		} else {
			this.isLast = false;
		}
	}

	/**
	 * 计算总页数-取模数，余数大于0则页数除后加1。
	 * @return
	 */
	public int getTotalPage() {
		if ((this.totalRow % this.pageSize) == 0) {
			this.totalPage = this.totalRow / this.pageSize;// 计算多少页
		} else {
			this.totalPage = this.totalRow / this.pageSize + 1;// 计算多少页
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Map<String, String> getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(Map<String, String> queryParam) {
		this.queryParam = queryParam;
	}

	public String getOrderColunm() {
		return orderColunm;
	}

	public void setOrderColunm(String orderColunm) {
		this.orderColunm = orderColunm;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	/**
	 * 需要查询显示第几页
	 * @return
	 */
	public int getPageNumber() {
		if (pageNumber <= 0) {
			pageNumber = DictKeys.default_pageNumber;
		}
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * 每页显示多少条数据
	 * @return
	 */
	public int getPageSize() {
		if (pageSize <= 0) {
			pageSize = DictKeys.default_pageSize;
		}
		if (pageSize > 200) {
			pageSize = DictKeys.default_pageSize;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageCount() {
		return currentPageCount;
	}

	public void setCurrentPageCount(int currentPageCount) {
		this.currentPageCount = currentPageCount;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

}
