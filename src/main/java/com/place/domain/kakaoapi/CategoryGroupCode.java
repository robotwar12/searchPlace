package com.place.domain.kakaoapi;

import java.util.HashMap;
import java.util.Map;

public class CategoryGroupCode {

	public static Map<String, String> getCategory_Group_Code() {

		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("MT1", "대형마트");
		codeMap.put("CS2", "편의점");
		codeMap.put("PS3", "어린이집, 유치원");
		codeMap.put("SC4", "학교");
		codeMap.put("AC5", "학원");
		codeMap.put("PK6", "주차장");
		codeMap.put("OL7", "주유소, 충전소");
		codeMap.put("SW8", "지하철역");
		codeMap.put("BK9", "은행");
		codeMap.put("CT1", "문화시설");
		codeMap.put("AG2", "중개업소");
		codeMap.put("PO3", "공공기관");
		codeMap.put("AT4", "관광명소");
		codeMap.put("AD5", "숙박");
		codeMap.put("FD6", "음식점");
		codeMap.put("CE7", "카페");
		codeMap.put("HP8", "병원");
		codeMap.put("PM9", "약국");

		return codeMap;
	}

}
