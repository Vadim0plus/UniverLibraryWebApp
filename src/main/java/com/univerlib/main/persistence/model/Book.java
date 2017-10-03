package com.univerlib.main.persistence.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Book {
    private Long id;
    private Long bookNumber;
    private String name;
    private String desc;
    private Set<String> authors;
    private int publishYear;
    private Set<String> tags;
    private String publishHouse;

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public Book(long id,Long bookNumber, String name, String desc,int publishYear,String publishHouse) {
        this.id = id;
        this.bookNumber = bookNumber;
        this.name = name;
        this.desc = desc;
        this.authors = null;
        this.publishYear = publishYear;
        this.tags = null;
        this.publishHouse = publishHouse;
    }

    /* Default Book Constructor */
    public Book() {};

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

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Book.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Book other = (Book) obj;
        if ((this.getId() == null) ? (other.getId() != null) : !this.getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = hash + (this.getId() != null ? this.getId().intValue() : 0);
        hash = hash % 70;
        return hash;
    }
}
