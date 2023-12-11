package edu.pnu.service;

import java.util.List;
import java.util.Map;

import edu.pnu.domain.Member;

public interface MemberService {
	
	void insertMember(Member member);
	
	String findMember(String username);
	
	List<Object> getProfile(String username);
	
	void updateProfile(Map<String, String> profile);

}
