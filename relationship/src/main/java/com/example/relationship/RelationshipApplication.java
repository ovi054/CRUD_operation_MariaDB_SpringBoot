package com.example.relationship;

import com.example.relationship.model.Book;
import com.example.relationship.model.Page;
import com.example.relationship.repository.BookRepository;
import com.example.relationship.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RelationshipApplication implements CommandLineRunner {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	PageRepository pageRepository;
	public static void main(String[] args) {

		SpringApplication.run(RelationshipApplication.class, args);
	}

	public void run(String... args) throws Exception
	{
		Book book = new Book(1,"Spring Boot");
		bookRepository.save(book);
		Book book2 = new Book(2,"Java Book");
		bookRepository.save(book2);
		Page page1 = new Page(1,50,book);
		pageRepository.save(page1);
		Page page2 = new Page(2,30,book);
		pageRepository.save(page2);
		Page page3 = new Page(1,40,book2);
		pageRepository.save(page3);
	}

}
