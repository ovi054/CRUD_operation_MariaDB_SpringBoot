package com.example.relationship.controller;

import com.example.relationship.model.Book;
import com.example.relationship.repository.BookRepository;
import com.example.relationship.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getEmployeeById(@PathVariable String id)
    {
        return this.bookService.getEmployeeById(id);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book)
    {
        return this.bookService.createBook(book);
    }

    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable int id)
    {
        this.bookService.deleteBook(id);
    }
}
