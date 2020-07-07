package com.feedback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedback.model.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{
	public List<Feedback> findByCountry(String country);
	public List<Feedback> findByRating(int rating);

}
