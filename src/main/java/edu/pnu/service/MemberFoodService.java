package edu.pnu.service;

import java.util.List;
import java.util.Map;

public interface MemberFoodService {

	List<Object> getMemberFood(String mf);
	
	void insertMemberFood(Map<String, String> mf);

}
