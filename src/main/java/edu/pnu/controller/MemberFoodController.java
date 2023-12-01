package edu.pnu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.MemberFoodServiceImpl;

@RestController
public class MemberFoodController {
	
	@Autowired
	private MemberFoodServiceImpl memberFoodService;

	@PostMapping("/api/private/save")
	public void saveMemberFood(@RequestBody String s) {
		System.out.println(s);
	}
	
	@PostMapping("/api/private/memberfoodget")
	public ResponseEntity<?> getMemberFood(@RequestBody String mf) {
		return ResponseEntity.ok().body(memberFoodService.getMemberFood(mf));
	}
	
	@PostMapping("/api/private/memberfoodinsert")
	public void insertMemberFood(@RequestBody Map<String, String> mf) {
		memberFoodService.insertMemberFood(mf);
	}
}
