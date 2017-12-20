package com.yf.sblocaldemo.service.common.impl;

import com.yf.sblocaldemo.domain.common.Feedback;
import com.yf.sblocaldemo.mapper.common.FeedbackMapper;
import com.yf.sblocaldemo.service.common.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackMapper feedbackMapper;

	@Override
	public void insertFeedback(Feedback feedback) {
		feedbackMapper.insert(feedback);
	}
	
}
