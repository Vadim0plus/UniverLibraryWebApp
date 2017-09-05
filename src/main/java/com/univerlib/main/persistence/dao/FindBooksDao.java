package com.univerlib.main.persistence.dao;

import com.univerlib.main.persistence.model.Book;

import java.util.List;

public interface FindBooksDao {
    List<Book> findBooks(long id, String name);
}
