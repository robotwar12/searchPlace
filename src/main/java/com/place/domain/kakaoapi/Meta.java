package com.place.domain.kakaoapi;

/**
 * 카카오API의 Response객체 - Api : 키워드로 장소 검색(/v2/local/search/keyword.json)
 */
public class Meta {
	private int total_count;

	private String is_end;

	private int pageable_count;

	private Same_name same_name;

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public String getIs_end() {
		return is_end;
	}

	public void setIs_end(String is_end) {
		this.is_end = is_end;
	}

	public int getPageable_count() {
		return pageable_count;
	}

	public void setPageable_count(int pageable_count) {
		this.pageable_count = pageable_count;
	}

	public Same_name getSame_name() {
		return same_name;
	}

	public void setSame_name(Same_name same_name) {
		this.same_name = same_name;
	}

	@Override
	public String toString() {
		return "ClassPojo [total_count = " + total_count + ", is_end = " + is_end + ", pageable_count = "
				+ pageable_count + ", same_name = " + same_name + "]";
	}
}
