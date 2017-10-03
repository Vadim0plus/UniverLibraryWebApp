package com.univerlib.main.persistence.service;

import com.univerlib.main.persistence.model.Book;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public interface FindBooksService {
    List<Book> findBookWithID(long id);
    List<Book> findBooksWithBookNumber(Long bookNumber);
    List<Book> findBooksWithName(String name);
    List<Book> findBooksWithDescription(String desc);
    Queue<Book> findBooksWithAuthors(String authors, boolean strictly);
    List<Book> findBooksWithPublishYear(int year);
    Queue<Book> findBooksWithTags(String tags, boolean strictly );
    List<Book> findBooksWithPublishHouse(String publishHouse);
    List<Book> findBooksWithParams(Map<String,String> mapParams);
}
