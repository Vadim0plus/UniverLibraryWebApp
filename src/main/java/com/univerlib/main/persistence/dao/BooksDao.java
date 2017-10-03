package com.univerlib.main.persistence.dao;

import com.univerlib.main.persistence.model.Book;

public interface BooksDao {
    long addBook(Book addingBook);
    boolean deleteBook(Book deletingBook);
    boolean deleteBook(long bookID);
    boolean updateBook(Book updatingBook);
    Book viewBook(long bookID);
}
