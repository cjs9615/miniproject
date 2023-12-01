package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.MemberFood;

public interface MemberFoodRepository extends JpaRepository<MemberFood, Long> {

	@Query("SELECT mf.id, mf.food, mf.gram, mf.time FROM MemberFood mf WHERE mf.date = %?1% AND mf.member.username = %?2%")
	List<Object> findByDateAndMember(String date, String username);
}
