package com.univerlib.main.persistence.service.impl;

import com.univerlib.main.persistence.dao.FindBooksDao;
import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.FindBooksServiceWithParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

@Service
public class FindBooksServiceWithParamImpl implements FindBooksServiceWithParam{

    @Autowired
    protected FindBooksDao findBooksDao;


    public List<Book> findBookWithID(long id) {
        Book findBooks = new Book();
        findBooks.setId(id);

        List<Book> listBooks = findBooksDao.findBooks(findBooks);
        return listBooks;
    }

    public List<Book> findBooksWithBookNumber(Long bookNumber) {
        Book findBooks = new Book();
        findBooks.setBookNumber(bookNumber);

        List<Book> listBooks = findBooksDao.findBooks(findBooks);
        return listBooks;
    }

    public List<Book> findBooksWithName(String name) {
        Book findBooks = new Book();
        findBooks.setName(name);

        List<Book> listBooks = findBooksDao.findBooks(findBooks);
        return listBooks;
    }

    public List<Book> findBooksWithDescription(String desc) {
        Book findBooks = new Book();
        findBooks.setDesc(desc);

        List<Book> listBooks = findBooksDao.findBooks(findBooks);
        return listBooks;
    }

    public List<Book> findBooksWithAuthors(String authors) {
        StringTokenizer st = new StringTokenizer(authors, ",;");
        List<String> authorsList = new ArrayList<String>(st.countTokens());

        while(st.hasMoreTokens()) {
            authorsList.add(st.nextToken());
        }

        Book findBooks = new Book();
        findBooks.setAuthors(authorsList);

        List<Book> listBooks = findBooksDao.findBooks(findBooks);
        return listBooks;
    }

    public List<Book> findBooksWithPublishDate(String date) {

        Date publishDate = null;
        try {
            publishDate = DateFormat.getDateInstance().parse(date);

            Book findBooks = new Book();
            findBooks.setPublishDate(publishDate);

            List<Book> listBooks = findBooksDao.findBooks(findBooks);
            return listBooks;

        } catch (ParseException e) {
            return null;
        }

    }

    public List<Book> findBooksWithTags(String tags) {
        StringTokenizer st = new StringTokenizer(tags, ",;");
        Set<String> tagsSet = new HashSet<String>(st.countTokens());

        while(st.hasMoreTokens()) {
            tagsSet.add(st.nextToken());
        }

        Book findBooks = new Book();
        findBooks.setTags(tagsSet);

        List<Book> listBooks = findBooksDao.findBooks(findBooks);
        return listBooks;
    }

    public List<Book> findBooksWithPublishHouse(String publishHouse) {
        Book findBooks = new Book();
        findBooks.setPublishHouse(publishHouse);

        List<Book> listBooks = findBooksDao.findBooks(findBooks);
        return listBooks;
    }
}
