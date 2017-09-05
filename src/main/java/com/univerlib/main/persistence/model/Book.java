package com.univerlib.main.persistence.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Book {
    private Long id;
    private Long bookNumber;
    private String name;
    private String desc;
    private List<String> authors;
    private Date publishDate;
    private Set<String> tags;
    private String publishHouse;

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Book(long id,Long bookNumber, String name, String desc,Date publishDate,String publishHouse) {
        this.id = id;
        this.bookNumber = bookNumber;
        this.name = name;
        this.desc = desc;
        this.authors = null;
        this.publishDate = publishDate;
        this.tags = null;
        this.publishHouse = publishHouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Long bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }
}
