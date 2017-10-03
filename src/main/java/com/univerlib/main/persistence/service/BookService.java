package com.univerlib.main.persistence.service;

import com.univerlib.main.persistence.model.Book;

public interface BookService {
    long addBook(Book addingBook);
    boolean updateBook(Book updatingBook);
    boolean deleteBook(long bookID);
    boolean deleteBook(Book delBook);
    Book viewBook(long bookID);
}
