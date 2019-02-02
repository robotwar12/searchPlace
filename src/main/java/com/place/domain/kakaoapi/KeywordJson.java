package com.place.domain.kakaoapi;

import java.util.Arrays;

/**
 * 카카오API의 Response객체 - Api : 키워드로 장소 검색(/v2/local/search/keyword.json)
 */
public class KeywordJson {

	private Documents[] documents;

	private Meta meta;

	public Documents[] getDocuments() {
		return documents;
	}

	public void setDocuments(Documents[] documents) {
		this.documents = documents;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	@Override
	public String toString() {
		return "Keyword [documents=" + Arrays.toString(documents) + ", meta=" + meta + "]";
	}

}
