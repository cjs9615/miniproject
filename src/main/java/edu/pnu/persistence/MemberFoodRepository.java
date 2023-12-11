package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.MemberFood;

public interface MemberFoodRepository extends JpaRepository<MemberFood, Long> {

	@Query("SELECT mf.id, mf.food, mf.gram, mf.time, mf.comment FROM MemberFood mf WHERE mf.date = %?1% AND mf.member.username = %?2% ORDER BY mf.time")
	List<Object> findByDateAndMember(String date, String username);
	
	@Query("SELECT mf.id, mf.food, mf.gram, mf.date FROM MemberFood mf WHERE mf.date >= %?1% AND mf.date <= %?2% AND mf.member.username = %?3% ORDER BY mf.date")
	List<Object> findByAllDateAndMember(String lastYear, String date, String username);
	
	@Query("SELECT mf FROM MemberFood mf WHERE mf.date = %?1% AND mf.time = %?2% AND mf.food.id = %?3% AND mf.member.username = %?4%")
	MemberFood findByDateAndTimeAndFoodAndMember(String date, String time, String food, String username);
}
