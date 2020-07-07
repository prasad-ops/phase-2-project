package com.feedback.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackDao;
import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackDao dao;

	@Override
	public Feedback createFeedback(Feedback fb) {
		
		return dao.save(fb);
	}

	@Override
	public Feedback updateFeedback(Feedback fb) {
		
		return dao.save(fb);
	}

	@Override
	public Feedback getFeedbackById(int id) throws BusinessException {
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Feedback fb=null;
		try {
		 fb=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for id "+id);
		}
		return fb;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		
		return dao.findAll();
	}

	@Override
	public List<Feedback> getFeedbackBycountry(String country) {
		
		return dao.findByCountry(country);
	}

	@Override
	public List<Feedback> getFeedbackByrating(int rating) {
		
		return dao.findByRating(rating);
	}

	@Override
	public void deleteFeedbackById(int id) {
		dao.deleteById(id);
	}

}
