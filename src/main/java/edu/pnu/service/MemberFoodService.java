package edu.pnu.service;

import java.util.List;
import java.util.Map;

public interface MemberFoodService {

	List<Object> getMemberFood(String mf);
	
	List<Object> getAllMemberFood(String mf);
	
	void insertMemberFood(Map<String, String> mf);
	
	void deleteMemberFood(Map<String, String> mf);
	
	void updateMemberFood(Map<String, String> mf);

}
