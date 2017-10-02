package com.univerlib.main.persistence.service.impl;

import com.univerlib.main.persistence.dao.FindBooksDao;
import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.FindBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

@Service
public class FindBooksServiceImpl implements FindBooksService {

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

    public List<Book> findBooksWithParams(Map<String, String> mapParams) {

        Set<Map.Entry<String, String>> set = mapParams.entrySet();
        List<Book> bookList;

        if(mapParams.containsKey("id")) {
            bookList = findBookWithID(Long.getLong(mapParams.get("id")));
            return bookList;
        }

        if(mapParams.containsKey("bookNumber")) {
            bookList = findBooksWithBookNumber(Long.getLong(mapParams.get("bookNumber")));
            return bookList;
        }

        Book findBooks = new Book();
        try {
            Class classbook = Class.forName("com.univerlib.main.persistence.model.Book");
            Field[] classbookfields = classbook.getDeclaredFields();
            for( Field f : classbookfields) {
                if(mapParams.containsKey(f.getName())) {
                    String name = f.getName();
                    try {
                        classbook.getDeclaredMethod("set"+ name ).invoke(findBooks,mapParams.get(name));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }

            bookList =  findBooksDao.findBooks(findBooks);
            return bookList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
