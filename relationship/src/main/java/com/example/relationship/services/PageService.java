package com.example.relationship.services;

import com.example.relationship.model.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface PageService {
    public List<Page> getAllPages();
    public Optional<Page> getPageById(String id);
    public Page createPage(Page page);
    public void deletePagebyID(int id);

    List<Integer> getBookbyPageNo(int page_no);
}
