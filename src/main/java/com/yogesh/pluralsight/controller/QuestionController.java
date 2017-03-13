package com.yogesh.pluralsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yogesh.pluralsight.domain.Question;
import com.yogesh.pluralsight.service.QuestionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	Page<Question> getAllQuestions(Pageable pageable) {
		return questionService.getAllQuestions(pageable);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	Question getQuestionById(@PathVariable Long id) {
		return questionService.getQuestionById(id);
	}
	
	@RequestMapping(value = "create", method = RequestMethod.PUT, produces = "application/json")
	Question createQuestion(@RequestBody Question question) {
		return questionService.createUpdateQuestion(question);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json")
	Question updateQuestion(@RequestBody Question question) {
		return questionService.createUpdateQuestion(question);
	}
	
}
