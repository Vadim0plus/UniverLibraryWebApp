package com.univerlib.main.persistence.service;

import com.univerlib.main.persistence.model.Book;

import java.util.List;

public interface FindBooksService {
    List<Book> findBooksWithName(String name);
    List<Book> findBookWithID(long id);
}
