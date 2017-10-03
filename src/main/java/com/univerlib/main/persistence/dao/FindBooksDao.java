package com.univerlib.main.persistence.dao;

import com.univerlib.main.persistence.model.Book;

import java.util.List;
import java.util.Set;

public interface FindBooksDao {
    List<Book> findBooks(Book findBooks);
    Set<Book> findBooksWithTags(Set<String> tags,boolean strictly);
    Set<Book> findBooksWithAuthors(Set<String> authors,boolean strictly);
}
