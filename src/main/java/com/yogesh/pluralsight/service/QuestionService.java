package com.yogesh.pluralsight.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yogesh.pluralsight.domain.Question;

public interface QuestionService {
	
	public Page<Question> getAllQuestions(Pageable pageable);
	
	public Question getQuestionById(Long questionId);
	
	public Question createUpdateQuestion(Question question);
}
