package com.place.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.place.domain.PlaceMember;
import com.place.repository.MemberRepository;

public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public PlaceMember findByid(String id) {
		return memberRepository.findById(id);
	}
}
