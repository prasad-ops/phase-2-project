package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService service;
	
	private MultiValueMap<String, String> map;

	@PostMapping("/feedback")
	public Feedback createFeedback(@RequestBody Feedback fb) {
		
		return service.createFeedback(fb);
	}

	@PutMapping("/feedback")
	public Feedback updateFeedback(@RequestBody Feedback fb) {
		
		return service.updateFeedback(fb);
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) {
		
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/feedbacks")
	public List<Feedback> getAllFeedback() {
		
		return service.getAllFeedback();
	}

	@GetMapping("/feedback/country/{country}")
	public List<Feedback> getFeedbackBycountry(@PathVariable("country") String country) {
		
		return service.getFeedbackBycountry(country);
	}

	@GetMapping("/feedback/rating/{rating}")
	public List<Feedback> getFeedbackByrating(@PathVariable("rating") int rating) {
		
		return service.getFeedbackByrating(rating);
	}

	@DeleteMapping("/feedback/{id}")
	public void deleteFeedbackById(@PathVariable("id") int id) {
		
		service.deleteFeedbackById(id);
	}

}
