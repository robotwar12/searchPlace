package com.place.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.place.domain.kakaoapi.CategoryGroupCode;
import com.place.service.TrendKeywordService;
import com.place.service.api.KakaoApiService;

@Controller
public class LoginController {
	@Autowired
	KakaoApiService apiService;

	@Autowired
	TrendKeywordService trendKeywordService;

	// 로그인
	@RequestMapping("/login")
	public String login(Model model, @RequestParam(required = false) String error) {

		model.addAttribute("error", error);
		return "login";
	}

	// 로그인후 메인이동
	@RequestMapping(value = "/")
	public String main(Model model) {
		
		//인기 검색어
		model.addAttribute("trendKeyword", trendKeywordService.listTrendKeyword());

		// 카테고리 코드
		model.addAttribute("categroyCode", CategoryGroupCode.getCategory_Group_Code());

		return "main";
	}

}
