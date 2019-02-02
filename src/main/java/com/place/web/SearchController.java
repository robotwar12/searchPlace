package com.place.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.place.domain.TrendKeyword;
import com.place.domain.kakaoapi.CategoryGroupCode;
import com.place.domain.kakaoapi.KeywordResult;
import com.place.service.TrendKeywordService;
import com.place.service.api.KakaoApiService;

@Controller
public class SearchController {
	@Autowired
	KakaoApiService apiService;

	@Autowired
	TrendKeywordService trendKeywordService;

	@RequestMapping(value = "/searchKeword")
	public String searchKeword(@RequestParam String keyword, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "5") int size,
			@RequestParam(value = "category_group_code", defaultValue = "") String code, Model model)
			throws JsonParseException, JsonMappingException, IOException {

		KeywordResult keywordResult = apiService.getApiData(keyword, page, size, code);
		// 키워드 조회등록
		TrendKeyword trendKeyword = new TrendKeyword();
		trendKeyword.setKeyword(keyword);
		trendKeywordService.insertTrendKeyword(trendKeyword);
		
		//화면에 값 전달
		model.addAttribute("trendKeyword", trendKeywordService.listTrendKeyword()); //인기 검색어
		model.addAttribute("placeInfolist", keywordResult.getKeywordJson().getDocuments()); //장소리스트 정보
		model.addAttribute("placeInfoMeta", keywordResult.getKeywordJson().getMeta()); //
		model.addAttribute("currentPageNum", keywordResult.getCurrent_pageNum()); //현재 페이지번호
		model.addAttribute("inputKeyword", keywordResult.getInput_keyword());//입력키워드
		model.addAttribute("totalPage", keywordResult.getTotal_page());//총 페이지수
		model.addAttribute("pageSize", keywordResult.getPage_size()); //페이지 사이즈
		model.addAttribute("codeVal", keywordResult.getCategory_group_code());//입력 카테고리코드
		model.addAttribute("categroyCode", CategoryGroupCode.getCategory_Group_Code());	// 카테고리 코드

		return "main";
	}
}
