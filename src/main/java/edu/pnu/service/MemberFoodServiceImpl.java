package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.MemberFood;
import edu.pnu.persistence.FoodRepository;
import edu.pnu.persistence.MemberFoodRepository;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberFoodServiceImpl implements MemberFoodService {

	@Autowired
	MemberFoodRepository memberFoodRepository;
	
	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public List<Object> getMemberFood(String mf){
		return memberFoodRepository.findByDateAndMember(mf.split(",")[0], mf.split(",")[1]);
	}
	
	@Override
	public List<Object> getAllMemberFood(String mf) {
		return memberFoodRepository.findByAllDateAndMember(mf.split(",")[0], mf.split(",")[1], mf.split(",")[2]);
	}

	@Override
	public void insertMemberFood(Map<String, String> mf) {
		memberFoodRepository.save(MemberFood.builder()
										.date(mf.get("date"))
										.time(mf.get("time"))
										.food(foodRepository.findById(Long.parseLong(mf.get("foodId"))).get())
										.gram(Double.parseDouble(mf.get("gram")))
										.member(memberRepository.findById(mf.get("memberUsername")).get())
										.build());
		
	}

	@Override
	public void deleteMemberFood(Map<String, String> mf) {
		MemberFood mfDelete = memberFoodRepository.findByDateAndTimeAndFoodAndMember(mf.get("date"), mf.get("time"), mf.get("foodId"), mf.get("memberUsername"));
		memberFoodRepository.delete(mfDelete);
	}

	@Override
	public void updateMemberFood(Map<String, String> mf) {
		MemberFood mfUpdate = memberFoodRepository.findByDateAndTimeAndFoodAndMember(mf.get("date"), mf.get("time"), mf.get("foodId"), mf.get("memberUsername"));
		String gram = mf.get("gram");
		String comment = mf.get("comment");
		if(gram != null && comment != null) {
			mfUpdate.setGram(Double.parseDouble(gram));
			mfUpdate.setComment(comment);
		}
		else if(gram != null) {
			mfUpdate.setGram(Double.parseDouble(gram));
		}
		else mfUpdate.setComment(comment);
		memberFoodRepository.save(mfUpdate);
	}

}
