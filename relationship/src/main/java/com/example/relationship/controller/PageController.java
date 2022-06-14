package com.example.relationship.controller;

import com.example.relationship.model.Book;
import com.example.relationship.model.Page;
import com.example.relationship.repository.PageRepository;
import com.example.relationship.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PageController {
    @Autowired
    private PageService pageService;

    @GetMapping("/pages")
    public List<Page> getAllPages() {
        return this.pageService.getAllPages();
    }

    @GetMapping("/pages/{id}")
    public Optional<Page> getPageById(@PathVariable String id)
    {
        return this.pageService.getPageById(id);
    }

    @PostMapping("/pages")
    public Page createPage(@RequestBody Page page)
    {
        return this.pageService.createPage(page);
    }
    @DeleteMapping("/pages/{id}")
    public void deletePagebyID(@PathVariable int id)
    {
        this.pageService.deletePagebyID(id);
    }

    @GetMapping("/pageno/{page_no}")
    public List<Integer> getBookbyPageNo(@PathVariable int page_no)
    {
        return this.pageService.getBookbyPageNo(page_no);
    }

}
