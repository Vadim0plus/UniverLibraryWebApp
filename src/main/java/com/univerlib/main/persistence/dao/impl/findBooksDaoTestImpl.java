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
        bookList.add(new Book(1,"cpp-programming", "programming in cpp language."));
        bookList.add(new Book(2,"java-programming", "programming in javs language."));
        bookList.add(new Book(3,"python-programming", "programming in python language."));
    }
    public List<Book> findBooks(long id, String name) {
        List<Book> dest = new ArrayList<Book>();
        if( id != 0) {
            for(Book book : bookList ) {
                if( book.getId() == id) {
                    dest.add(book);
                }
            }
        }
        else {
            for(Book book : bookList) {
                if( book.getName() == name )
                    dest.add(book);
            }
        }
        return dest;
    }
}
