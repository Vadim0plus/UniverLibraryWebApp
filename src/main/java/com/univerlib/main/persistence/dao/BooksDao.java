package com.univerlib.main.persistence.dao;

import com.univerlib.main.persistence.model.Book;

public interface BooksDao {
    Book addBook(Book addingBook);
    Book deleteBook(Book deletingBook);
    Book updateBook(Book updatingBook);
    Book viewBook(Book viewBook);
}
