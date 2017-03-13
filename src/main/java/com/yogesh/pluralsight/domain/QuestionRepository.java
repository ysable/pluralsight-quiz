package com.yogesh.pluralsight.domain;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author yogesh.sable
 *
 */
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
	
	Question findOne(Long questionId);
	
	Collection<Question> findAll();
	
	Question save(Question question);

}
