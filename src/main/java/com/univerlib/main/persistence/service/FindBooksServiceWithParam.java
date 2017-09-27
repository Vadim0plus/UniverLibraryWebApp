package com.univerlib.main.persistence.service;

import com.univerlib.main.persistence.model.Book;

import java.util.List;
import java.util.Set;

public interface FindBooksServiceWithParam {
    List<Book> findBookWithID(long id);
    List<Book> findBooksWithBookNumber(Long bookNumber);
    List<Book> findBooksWithName(String name);
    List<Book> findBooksWithDescription(String desc);
    List<Book> findBooksWithAuthors(String authors);
    List<Book> findBooksWithPublishDate(String date);
    List<Book> findBooksWithTags(String tags );
    List<Book> findBooksWithPublishHouse(String publishHouse);
}
