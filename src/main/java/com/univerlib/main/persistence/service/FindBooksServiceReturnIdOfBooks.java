package com.univerlib.main.persistence.service;

import com.univerlib.main.persistence.model.Book;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

public interface FindBooksServiceReturnIdOfBooks {
    Set<Long> findBooksWithBookNumber(long bookNumber);
    Queue<Long> findBooksWithName(String name);
    Queue<Long> findBooksWithDescription(String desc);
    Queue<Long> findBooksWithAuthors(String authors, boolean strictly);
    Set<Long> findBooksWithPublishYear(int year);
    Queue<Long> findBooksWithTags(String tags, boolean strictly );
    Set<Long> findBooksWithPublishHouse(String publishHouse);
    Queue<Long> findBooksWithParams(Map<String,String> mapParams);
}
