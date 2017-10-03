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

    public List<Book> findBooksWithPublishYear(int year) {
            return findBooksDao.findBooksWithPublishYear(year);
    }

    public Queue<Book> findBooksWithTags(String tags, boolean stricty) {

        /* Get the tags */
        StringTokenizer st = new StringTokenizer(tags, ",;");
        Set<String> tagsSet = new HashSet<String>(st.countTokens());

        while(st.hasMoreTokens()) {
            tagsSet.add(st.nextToken());
        }

        /* find the books with required tags */
        Set<Book> id_booksSet = findBooksDao.findBooksWithTags(tagsSet, stricty);

        Queue<Book> queue = new PriorityQueue<Book>();
        if(!stricty) {

            Map<Integer, List<Book>> map = new HashMap<Integer, List<Book>>();

            Iterator it = id_booksSet.iterator();
            int max_count = 0;
            while (it.hasNext()) {
                Book book = (Book) it.next();
                max_count = (book.getTags().size() > max_count) ? book.getTags().size() : max_count;
                if (map.containsKey(book.getTags().size())) {
                    List<Book> list = map.get(book.getTags().size());
                    list.add(book);
                } else {
                    List<Book> list = new ArrayList<Book>();
                    list.add(book);
                    map.put(book.getTags().size(), list);
                }
            }

            for (int i = max_count; i > 0; i--) {
                if (map.containsKey(i))
                    queue.addAll(map.get(i));
            }

            return queue;
        }
        else {
            queue.addAll(id_booksSet);
            return queue;
        }
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
