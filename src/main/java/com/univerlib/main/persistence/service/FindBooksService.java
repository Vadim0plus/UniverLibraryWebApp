package com.univerlib.main.persistence.service;

import com.univerlib.main.persistence.model.Book;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public interface FindBooksService {
    Set<Book> findBooksWithBookNumber(long bookNumber);
    Queue<Book> findBooksWithName(String name);
    Queue<Book> findBooksWithDescription(String desc);
    Queue<Book> findBooksWithAuthors(String authors, boolean strictly);
    Set<Book> findBooksWithPublishYear(int year);
    Queue<Book> findBooksWithTags(String tags, boolean strictly );
    Set<Book> findBooksWithPublishHouse(String publishHouse);
    Queue<Book> findBooksWithParams(Map<String,String> mapParams);
}
