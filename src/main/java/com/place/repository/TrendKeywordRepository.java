package com.place.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.place.domain.TrendKeyword;

public interface TrendKeywordRepository extends JpaRepository<TrendKeyword, Long> {

	List<TrendKeyword> findTop10ByOrderByKeywordSearchCountDesc();
	
	Long countByKeyword(String keyword);

	TrendKeyword findByKeyword(String keyword);
}
