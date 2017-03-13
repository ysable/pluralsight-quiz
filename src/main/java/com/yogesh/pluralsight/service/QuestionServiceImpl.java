package com.yogesh.pluralsight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yogesh.pluralsight.domain.Question;
import com.yogesh.pluralsight.domain.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	
	public QuestionServiceImpl () {

	}
	
	@Override
	public Page<Question> getAllQuestions(Pageable pageable) {
		return questionRepository.findAll(pageable);
		
	}

	@Override
	public Question getQuestionById(Long questionId) {
		return questionRepository.findOne(questionId);
	}

	@Override
	public Question createUpdateQuestion(Question question) {
		return questionRepository.save(question);
	}

}
