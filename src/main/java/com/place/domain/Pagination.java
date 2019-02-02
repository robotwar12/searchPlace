package com.place.domain;

public class Pagination {

	int total_count; // 총데이터
	int current_pageNum; // 현재페이지번호
	int page_size; // 한페이지에 출력할 데이터 갯수
	int total_page; // 계산된 총 페이지수

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getCurrent_pageNum() {
		return current_pageNum;
	}

	public void setCurrent_pageNum(int current_pageNum) {
		this.current_pageNum = current_pageNum;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

	public int getTotal_page() {
		return total_page;
	}

	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}

	@Override
	public String toString() {
		return "Pagination [total_count=" + total_count + ", current_pageNum=" + current_pageNum + ", page_size="
				+ page_size + ", total_page=" + total_page + "]";
	}

}
