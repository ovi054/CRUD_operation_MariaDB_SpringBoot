package com.example.relationship.model;



import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "pages")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pageID;
    private int pageNo;
    private int totalWords;

    @ManyToOne
    @JsonProperty()
    @JoinColumn(name = "book_id")
    Book book;


    public Page() {
    }

    public Page(int pageNo, int totalWords,Book book) {
        this.pageNo = pageNo;
        this.totalWords = totalWords;
        this.book = book;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getPageID() {
        return pageID;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    public Book getBook() {
        return book;
    }
}
