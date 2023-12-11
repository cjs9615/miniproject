package edu.pnu.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberServiceImpl;


@RestController
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@PostMapping("/login")
	public void login() {}

	@PostMapping("/api/public/signup")
	public void insertMember(@RequestBody Member member) {
		memberService.insertMember(member);
	}
	
	@PostMapping("/api/public/checkdouble")
	public ResponseEntity<?> findMember(@RequestBody String username) {
		//return memberService.findMember(username);
		return ResponseEntity.ok().body(memberService.findMember(username));
	}
	
	@PostMapping("/api/private/profileget")
	public ResponseEntity<?> getProfile(@RequestBody String username) {
		return ResponseEntity.ok().body(memberService.getProfile(username));
	}
	
	@PutMapping("/api/private/profileupdate")
	public void updateProfile(@RequestBody Map<String, String> profile) {
		memberService.updateProfile(profile);
	}
}
