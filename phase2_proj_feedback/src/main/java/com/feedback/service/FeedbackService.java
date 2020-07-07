package com.feedback.service;

import java.util.List;

import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;

public interface FeedbackService {
	
	public Feedback createFeedback(Feedback fb);
	public Feedback updateFeedback(Feedback fb);
	public Feedback getFeedbackById(int id) throws BusinessException;
	public List<Feedback> getAllFeedback();
	public List<Feedback> getFeedbackBycountry(String country);
	public List<Feedback> getFeedbackByrating(int rating);
	public void deleteFeedbackById(int id);

}
