package com.place.util;

import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestApiHelper {

	/**
	 * api 호출
	 * 
	 * @param endPointUrl
	 * @param header
	 * @param param
	 * @return
	 */
	public static String apiCall(String endPointUrl, Map<String, String> header, Map<String, Object> param) {
		RestTemplate restTemplate = new RestTemplate();

		// 헤더설정
		HttpEntity<String> entity = new HttpEntity<String>(getHeaders(header));
		URI endUri = getURI(endPointUrl, param);
		// api 호출
		ResponseEntity<String> response = restTemplate.exchange(endUri, HttpMethod.GET, entity, String.class);
		
		return 	response.getBody();
	}

	/**
	 * 헤더 값 설정
	 * 
	 * @param header
	 * @return
	 */
	private static  HttpHeaders getHeaders(Map<String, String> header) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);

		for (String key : header.keySet()) {
			httpHeaders.add(key, header.get(key));
		}
		return httpHeaders;
	}

	/**
	 * UriComponent 생성
	 * 
	 * @return
	 */
	private static URI getURI(String endPointUrl, Map<String, Object> param) {

		// 엔드포인트 설정
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(endPointUrl);

		// 파리미터설정
		for (String key : param.keySet()) {
			builder.queryParam(key, param.get(key));
		}

		// 한글깨짐 방지
		URI endUri = builder.build().encode().toUri();

		return endUri;
	}
}
