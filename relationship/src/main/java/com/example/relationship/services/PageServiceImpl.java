package com.example.relationship.services;

import com.example.relationship.model.Page;
import com.example.relationship.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    PageRepository pageRepository;
    @Override
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    @Override
    @Cacheable(value = "pages",key = "#id")
    public Optional<Page> getPageById(String id) {
        System.out.println("Page From DB");
        Optional<Page> page= pageRepository.findById(Integer.parseInt(id));
        return page;
    }

    @Override
    public Page createPage(Page page) {
        return pageRepository.save(page);
    }

    @Override
    @CacheEvict(value = "pages", allEntries = false, key = "#id")
    public void deletePagebyID(int id) {
        pageRepository.deleteById(id);
    }

    @Override
    public List<Integer> getBookbyPageNo(int page_no) {
        List<Page> pageList = pageRepository.findAll();
        List<Integer> list = new ArrayList<Integer>();
        Integer intValue = Math.toIntExact(pageRepository.count());
        for(Integer i=0;i<intValue;i++)
        {
            Page page = pageList.get(i);
            if(page.getPageNo() == page_no)
            {
                list.add(page.getBook().getId());
            }
        }
        //list.add(intValue);
        return list;
    }
}
