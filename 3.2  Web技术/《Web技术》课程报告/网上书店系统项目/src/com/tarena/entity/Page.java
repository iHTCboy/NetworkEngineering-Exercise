package com.tarena.entity;

public class Page {

	public Page() {

	}

	/**
	 * ��ǰҳ
	 */
	private int pageNo=1;
	/**
	 * ÿҳ����
	 */
	private int pageSize=5;
	
	/**
	 * ��ʼ��
	 */
	private int begin;
	/**
	 * ������
	 */
	private int countItem;
	/**
	 * ��ҳ��
	 */
	private int countPage;
	
	public int getCountPage() {
		//������ҳ��
		if(countItem%pageSize==0){
			countPage=countItem/pageSize;
		}else{
			countPage=countItem/pageSize+1;
		}
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getCountItem() {
		return countItem;
	}

	public void setCountItem(int countItem) {
		this.countItem = countItem;
	}

	public int getBegin() {
		return (pageNo-1)*pageSize;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
