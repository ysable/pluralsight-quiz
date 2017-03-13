package com.yogesh.pluralsight.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author yogesh.sable
 * 
 *         Entity object for Question.
 *
 */
@Entity
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8654108449406196755L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "QUESTION_NAME")
	private String questionName;

	@Column(name = "ANSWER")
	private String correctAnswer;

	@JsonManagedReference
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Distractor> distractors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<Distractor> getDistractors() {
		return distractors;
	}

	public void setDistractors(List<Distractor> distractors) {
		this.distractors = distractors;
	}

	public Question() {
		
	}

	public Question(String questionName, String correctAnswer, List<Distractor> distractors) {
		super();
		this.questionName = questionName;
		this.correctAnswer = correctAnswer;
		this.distractors = distractors;
	}

	public Question(String questionName, String correctAnswer) {
		super();
		this.questionName = questionName;
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionName=" + questionName + ", correctAnswer=" + correctAnswer
				+ ", distractors=" + distractors + "]";
	}

}
