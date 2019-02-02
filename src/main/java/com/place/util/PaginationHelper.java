package com.place.util;

import com.place.domain.Pagination;

public class PaginationHelper {
	private static int total_count = 0; // 총 데이터수
	private static int current_pageNum = 0; // 현재 페이지
	private static int page_size = 0; // 페이지당 출력 데이터수
	private static int total_Page = 0; // 계산된 총 페이지수

	/**
	 * 총 페이지수 계산
	 * @param pagination
	 * @return 총페이지수
	 */
	public static int totalPage(Pagination pagination) {
		total_count = pagination.getTotal_count();
		current_pageNum = pagination.getCurrent_pageNum();
		page_size = pagination.getPage_size();

		total_Page = total_count / page_size;

		if (total_count % page_size > 0) {
			total_Page++;
		}

		if (total_Page < current_pageNum) {
			current_pageNum = total_Page;
		}

		return total_Page;
	}

}
