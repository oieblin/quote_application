/*
package com.ccufs.quote_application;

import com.ccufs.quote_application.model.Author;
import com.ccufs.quote_application.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QuoteApplicationTests {
	@Autowired private AuthorRepository authorRepository;

	@Test
	void testFindAuthorByFaculty() {
		String someFaculty = "КСиС";
		List<Author> listAuthors = authorRepository.findAuthorByFaculty("КСиС");
		listAuthors.forEach(System.out::println);
		Assertions.assertDoesNotThrow(this::testFindAuthorByFaculty);
	}


}
*/
