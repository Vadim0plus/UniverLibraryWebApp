package com.univerlib.main.persistence.dao.impl;

import com.univerlib.main.persistence.dao.BooksDao;
import com.univerlib.main.persistence.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class BooksDaoTestImpl implements BooksDao {

    List<Book> listBook = new ArrayList<Book>();
    Long count = new Long(0);

    public Book addBook(Book addingBook) {
        addingBook.setId(++count);
        listBook.add(addingBook);
        return addingBook;
    }

    public Book deleteBook(Book deletingBook) {
        Iterator it = listBook.iterator();
        while(it.hasNext()) {
            Book b = (Book)it.next();
            if(b.equals(deletingBook)) {
                it.remove();
                return b;
            }
        }
        return null;
    }

    public Book updateBook(Book updatingBook) {
        Iterator it = listBook.iterator();
        while(it.hasNext()) {
            Book b = (Book)it.next();
            if(b.equals(updatingBook)) {
                updatingBook.setId(b.getId());
                it.remove();
                Book addedBook = addBook(updatingBook);
                return addedBook;
            }
        }
        return null;
    }

    public Book viewBook(Book viewBook) {
        Iterator it = listBook.iterator();
        while(it.hasNext()) {
            Book b = (Book)it.next();
            if(b.equals(viewBook)) {
                return b;
            }
        }
        return null;
    }
}
