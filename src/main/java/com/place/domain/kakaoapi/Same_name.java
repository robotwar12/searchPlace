package com.place.domain.kakaoapi;

/**
 * 카카오API의 Response객체 - Api : 키워드로 장소 검색(/v2/local/search/keyword.json)
 */
public class Same_name {
	private String[] region;

	private String keyword;

	private String selected_region;

	public String[] getRegion() {
		return region;
	}

	public void setRegion(String[] region) {
		this.region = region;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSelected_region() {
		return selected_region;
	}

	public void setSelected_region(String selected_region) {
		this.selected_region = selected_region;
	}

	@Override
	public String toString() {
		return "ClassPojo [region = " + region + ", keyword = " + keyword + ", selected_region = " + selected_region
				+ "]";
	}
}
