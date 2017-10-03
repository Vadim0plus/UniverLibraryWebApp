package com.univerlib.main.persistence.dao;

import com.univerlib.main.persistence.model.Book;

import java.util.List;
import java.util.Set;

public interface FindBooksDao {
    Set<Book> findBooksWithBookNumber(long number);
    Set<Book> findBooksWithTags(Set<String> tags,boolean strictly);
    Set<Book> findBooksWithAuthors(Set<String> authors,boolean strictly);
    Set<Book> findBooksWithPublishHouse(String publishHouse);
    Set<Book> findBooksWithPublishYear(int year);
}
