package com.univerlib.main.persistence.service.impl;

import com.univerlib.main.persistence.dao.BooksDao;
import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BooksDao booksDao;

    public Book addBook(Book addingBook) {
        return booksDao.addBook(addingBook);
    }

    public Book updateBook(Book updatingBook) {
        return booksDao.updateBook(updatingBook);
    }

    public Book deleteBook(Book deletingBook) {
        return booksDao.deleteBook(deletingBook);
    }

    public Book viewBook(Book viewBook) {
        return booksDao.viewBook(viewBook);
    }
}
