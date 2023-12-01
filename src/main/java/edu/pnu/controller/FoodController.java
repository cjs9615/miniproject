package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.FoodServiceImpl;

@RestController
public class FoodController {
	
	@Autowired
	private FoodServiceImpl foodService;
	
	@PostMapping("/api/public/search")
	public ResponseEntity<?> searchFoodList(@RequestBody String keyword) {
		return ResponseEntity.ok().body(foodService.searchFoodList(keyword));
	}
}
