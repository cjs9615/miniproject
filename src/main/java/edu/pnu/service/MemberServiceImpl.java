package edu.pnu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void insertMember(Member member) {
		member.setEnabled(true);
		member.setRole(Role.ROLE_MEMBER);
		member.setPassword(encoder.encode(member.getPassword()));
		memberRepo.save(member);
	}

	@Override
	public String findMember(String username) {
		Optional<Member> option = memberRepo.findById(username);
		if (!option.isPresent()) {
			return "false";
		}
		return "true";
	}

	@Override
	public List<Object> getProfile(String username) {
		return memberRepo.findByUsername(username);
	}

	@Override
	public void updateProfile(Map<String, String> profile) {
		Member m = memberRepo.findById(profile.get("username")).get();
		String sex = profile.get("sex");
		String height = profile.get("height");
		String weight = profile.get("weight");
		if(sex != null && height != null && weight != null) {
			m.setSex(sex);
			m.setHeight(Double.parseDouble(height));
			m.setWeight(Double.parseDouble(weight));
		}
		else if(sex != null && height != null) {
			m.setSex(sex);
			m.setHeight(Double.parseDouble(height));
		}
		else if(sex != null && weight != null) {
			m.setSex(sex);
			m.setWeight(Double.parseDouble(weight));
		}
		else if(height != null && weight != null) {
			m.setHeight(Double.parseDouble(height));
			m.setWeight(Double.parseDouble(weight));
		}
		else if(sex != null) {
			m.setSex(sex);
		}
		else if(height != null) {
			m.setHeight(Double.parseDouble(height));
		}
		else if(weight != null) {
			m.setWeight(Double.parseDouble(weight));
		}
		else return;
		memberRepo.save(m);
	}

}
