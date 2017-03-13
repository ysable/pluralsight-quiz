package com.yogesh.pluralsight.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author yogesh.sable
 * 
 *         Entity object for Distractor. There will be multiple distractors
 *         (wrong answers) for a question
 *
 */
@Entity
public class Distractor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7019124821075431547L;

	public Distractor() {
	}

	@Id
	@GeneratedValue
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	private Question question;
	
	@Column(name = "DISTRACTOR")
	private String distractor;

	public Distractor(Question question, String distractor) {
		this.question = question;
		this.distractor = distractor;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	public String getDistractor() {
		return distractor;
	}


	public void setDistractor(String distractor) {
		this.distractor = distractor;
	}


	@Override
	public String toString() {
		return "Distractor [questionId=" + question.getId() + ", distractor=" + distractor + "]";
	}

}
