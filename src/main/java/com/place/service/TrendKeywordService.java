package com.place.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.place.domain.TrendKeyword;
import com.place.repository.TrendKeywordRepository;

@Component
public class TrendKeywordService {
	@Autowired
	TrendKeywordRepository trendKeywordRepo;

	// 트렌드키워드 등록
	public void insertTrendKeyword(TrendKeyword trendKeyword) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		// 중복데이터 확인
		String keyword = trendKeyword.getKeyword();

		Long dataCnt = trendKeywordRepo.countByKeyword(keyword);

		// 검색키워드가 기존에 존재하는경우 검색횟수 업데이트
		if (dataCnt > 0) {
			TrendKeyword uptTrendKeyword = trendKeywordRepo.findByKeyword(keyword); // 해당키워드 데이터 조회

			uptTrendKeyword.setKeywordSearchCount(uptTrendKeyword.getKeywordSearchCount() + 1);// 검색횟수 증가
			uptTrendKeyword.setUpdateDate(timestamp);

			trendKeywordRepo.save(uptTrendKeyword);

		// 새로운 검색키워드인경우 인서트
		} else {
			trendKeyword.setInsertDate(timestamp);
			trendKeyword.setUpdateDate(timestamp);

			trendKeywordRepo.save(trendKeyword);
		}
	}

	// 트렌드키워드 조회
	public List<TrendKeyword> listTrendKeyword() {
		return trendKeywordRepo.findTop10ByOrderByKeywordSearchCountDesc();
	}

}
