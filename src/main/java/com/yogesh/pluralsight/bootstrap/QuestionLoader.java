package com.yogesh.pluralsight.bootstrap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.yogesh.pluralsight.domain.Distractor;
import com.yogesh.pluralsight.domain.Question;
import com.yogesh.pluralsight.domain.QuestionRepository;

/**
 * @author yogesh.sable
 * 
 *         Loads the initial set of questions from the CSV.
 *
 */

@Component
public class QuestionLoader implements ApplicationListener<ContextRefreshedEvent> {

	private QuestionRepository questionRepository;

	private Logger log = Logger.getLogger(QuestionLoader.class);

	private static final String FILE_NAME = "code_challenge_question_dump.csv";
	
	@Autowired
	public void setQuestionRepository(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(FILE_NAME).getFile());
		
		List<Question> questionList = new ArrayList<Question>();
		try {
			Scanner scanner = new Scanner(file);
			// Skip the first line
			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
					String[] columns = line.split("\\|");
					// Get first 2 columns (question, answer)
					Question question = new Question(columns[0], columns[1]);
					// Get list of distractors
					String[] distractors = columns[2].split(",");
					List<Distractor> distractorList = new ArrayList<Distractor>();
					for (int i = 0; i < distractors.length; i++) {
						Distractor distractor = new Distractor(question, distractors[i]);
						distractorList.add(distractor);
					}
					question.setDistractors(distractorList);
					questionList.add(question);
				}
			scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	
		// Save all questions to the in memory H2 database
		questionRepository.save(questionList);
		log.info("Saved " + questionList.size() + " Questions");
	
	}
	
}
