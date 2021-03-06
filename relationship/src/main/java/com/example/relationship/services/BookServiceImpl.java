package com.example.relationship.services;

import com.example.relationship.model.Book;
import com.example.relationship.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Cacheable(value = "books", key = "#id")
    public Optional<Book> getEmployeeById(String id) {
        System.out.println("Fetched from DB");
        Optional<Book> book = bookRepository.findById(Integer.parseInt(id));
        return book;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
