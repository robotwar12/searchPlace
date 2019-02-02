package com.place.service.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.place.domain.Pagination;
import com.place.domain.kakaoapi.KeywordJson;
import com.place.domain.kakaoapi.KeywordResult;
import com.place.util.PaginationHelper;
import com.place.util.RestApiHelper;

@Service
public class KakaoApiService {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger(KakaoApiService.class);

	String appKey = "KakaoAK 9113af7ebeb99860d465ed244793d4dd";
	String uri = "https://dapi.kakao.com/v2/local/search/keyword.json";

	public KeywordResult getApiData(String keyword, int page, int size, String code)
			throws JsonParseException, JsonMappingException, IOException {

		// 요청 헤더 정보
		Map<String, String> header = new HashMap<>();
		header.put("Authorization", appKey);

		// 요청 파라미터
		Map<String, Object> param = new HashMap<>();
		param.put("query", keyword);
		param.put("page", page);
		param.put("size", size);
		param.put("category_group_code", code);

		// Api 응답
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		KeywordJson keywordJson = objectMapper.readValue(RestApiHelper.apiCall(uri, header, param), KeywordJson.class);

		// 페이징데이터 처리
		Pagination pagination = new Pagination();
		pagination.setCurrent_pageNum(page);
		pagination.setPage_size(size);
		pagination.setTotal_count(keywordJson.getMeta().getPageable_count());

		// 리턴데이터
		KeywordResult keywordResult = new KeywordResult();
		keywordResult.setKeywordJson(keywordJson);// api 호출 결과
		keywordResult.setCurrent_pageNum(page);// 현재페이지번호
		keywordResult.setInput_keyword(keyword);// 검색어
		keywordResult.setTotal_page(PaginationHelper.totalPage(pagination));
		keywordResult.setPage_size(size);
		keywordResult.setCategory_group_code(code);
		
		return keywordResult;
	}
}
