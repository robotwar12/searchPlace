package com.place.domain.kakaoapi;

/**
 * 사용자 화면에 출력해 줄 데이터 객체
 *
 */
public class KeywordResult {

	private int total_page; // 총 페이지수
	private int current_pageNum; // 현재 페이지번호
	private int page_size;
	private String input_keyword; // 사용자가 입력한 키워드
	private String category_group_code;
	private KeywordJson keywordJson;

	public int getTotal_page() {
		return total_page;
	}

	public void setTotal_page(int total_page) {
		this.total_page = total_page;
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

	public String getInput_keyword() {
		return input_keyword;
	}

	public void setInput_keyword(String input_keyword) {
		this.input_keyword = input_keyword;
	}

	public String getCategory_group_code() {
		return category_group_code;
	}

	public void setCategory_group_code(String category_group_code) {
		this.category_group_code = category_group_code;
	}

	public KeywordJson getKeywordJson() {
		return keywordJson;
	}

	public void setKeywordJson(KeywordJson keywordJson) {
		this.keywordJson = keywordJson;
	}

	@Override
	public String toString() {
		return "KeywordResult [total_page=" + total_page + ", current_pageNum=" + current_pageNum + ", page_size="
				+ page_size + ", input_keyword=" + input_keyword + ", category_group_code=" + category_group_code
				+ ", keywordJson=" + keywordJson + "]";
	}

}
