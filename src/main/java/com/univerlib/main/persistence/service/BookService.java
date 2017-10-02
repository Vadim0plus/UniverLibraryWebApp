package com.univerlib.main.persistence.service;

import com.univerlib.main.persistence.model.Book;

public interface BookService {
    Book addBook(Book addingBook);
    Book updateBook(Book updatingBook);
    Book deleteBook(Book deletingBook);
    Book viewBook(Book viewBook);
}
