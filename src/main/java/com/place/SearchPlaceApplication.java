package com.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.place.domain.PlaceMember;
import com.place.repository.MemberRepository;

@SpringBootApplication
public class SearchPlaceApplication implements CommandLineRunner {

	@Autowired
	MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(SearchPlaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		//사용자 샘플데이터 생성
		memberRepository.save(new PlaceMember("frood", encoder.encode("test1234")));
		memberRepository.save(new PlaceMember("neo", encoder.encode("test1234")));
		memberRepository.save(new PlaceMember("muzi", encoder.encode("test1234")));
		memberRepository.save(new PlaceMember("tube", encoder.encode("test1234")));
	}

}
