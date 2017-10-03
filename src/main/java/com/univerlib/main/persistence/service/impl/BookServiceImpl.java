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

    public long addBook(Book addingBook) {
        return booksDao.addBook(addingBook);
    }

    public boolean updateBook(Book updatingBook) {
        return booksDao.updateBook(updatingBook);
    }

    public boolean deleteBook(Book deletingBook) {
        return booksDao.deleteBook(deletingBook);
    }
    public boolean deleteBook(long bookID) {
        return booksDao.deleteBook(bookID);
    }

    public Book viewBook(long bookID) {
        return booksDao.viewBook(bookID);
    }
}
