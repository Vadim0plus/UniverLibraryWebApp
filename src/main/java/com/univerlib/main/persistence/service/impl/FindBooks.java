package com.univerlib.main.persistence.service.impl;

import com.univerlib.main.persistence.dao.FindBooksDao;
import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.FindBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindBooks implements FindBooksService{

    @Autowired
    private FindBooksDao findBooksDao;

    public List<Book> findBooksWithName(String name) {
        return findBooksDao.findBooks(0,name);
    }

    public List<Book> findBookWithID(long id) {
        return findBooksDao.findBooks(id,"");
    }
}
