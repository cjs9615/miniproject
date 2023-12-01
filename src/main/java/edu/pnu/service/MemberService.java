package edu.pnu.service;

import edu.pnu.domain.Member;

public interface MemberService {
	
	void insertMember(Member member);
	
	String findMember(String username); 

}
