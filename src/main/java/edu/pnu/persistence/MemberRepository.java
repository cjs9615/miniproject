package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
//	@Query("SELECT m.username FROM Member m WHERE m.username = %?1%")
//	String findByUseranme(String username);

	@Query("SELECT m.sex, m.height, m.weight FROM Member m WHERE m.username = %?1%")
	List<Object> findByUsername(String username);
}
