package com.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.place.domain.PlaceMember;

public interface MemberRepository extends JpaRepository<PlaceMember, Long>{
	 public PlaceMember findById(String id);
}
