package com.univerlib.main.persistence.dao.impl;

import com.univerlib.main.persistence.dao.FindBooksDao;
import com.univerlib.main.persistence.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class findBooksDaoTestImpl implements FindBooksDao {
    private List<Book> bookList;

    public findBooksDaoTestImpl() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book(1, (long) 100, "Cpp-programming", "programming with cpp language",
                null, ""));
        bookList.add(new Book(2, (long) 101, "Java-programming", "programming with java language",
                null, ""));
        bookList.add(new Book(3, (long) 102, "Python-programming", "programming with python language",
                null, ""));

    }
    public List<Book> findBooks(Book findBooks) {
        List<Book> dest = new ArrayList<Book>();
        if( findBooks.getId() != 0) {
            for(Book book : bookList ) {
                if( book.getId() == findBooks.getId()) {
                    dest.add(book);
                }
            }
            return dest;
        }

        if( findBooks.getName() != null) {
            for(Book book : bookList) {
                if( book.getName() == findBooks.getName() )
                    dest.add(book);
            }
            return dest;
        }

        return dest;
    }
}
