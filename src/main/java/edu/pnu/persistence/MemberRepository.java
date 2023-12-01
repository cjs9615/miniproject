package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
//	@Query("SELECT m.username FROM Member m WHERE m.username = %?1%")
//	String findByUseranme(String username);

}
