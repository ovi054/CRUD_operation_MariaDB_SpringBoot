package com.example.relationship.services;

import com.example.relationship.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAllBooks();
    public Optional<Book> getEmployeeById(String id);
    public Book createBook(Book book);
    public void deleteBook(int id);
}
