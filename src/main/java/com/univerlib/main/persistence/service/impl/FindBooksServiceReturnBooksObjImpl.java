package com.univerlib.main.persistence.service.impl;

import com.univerlib.main.persistence.dao.FindBooksDao;
import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.FindBooksServiceReturnBooksObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FindBooksServiceReturnBooksObjImpl implements FindBooksServiceReturnBooksObj {

    @Autowired
    protected FindBooksDao findBooksDao;


    public Set<Book> findBooksWithBookNumber(long bookNumber) {
        return findBooksDao.findBooksWithBookNumber(bookNumber);
    }

    public Queue<Book> findBooksWithName(String name) {
        return null;
    }

    public Queue<Book> findBooksWithDescription(String desc) {
        return null;
    }

    public Queue<Book> findBooksWithAuthors(String authors, boolean strictly) {

        /* Get the tags */
        StringTokenizer st = new StringTokenizer(authors, ",;");
        Set<String> authorsSet = new HashSet<String>(st.countTokens());

        while(st.hasMoreTokens()) {
            authorsSet.add(st.nextToken());
        }

        /* find the books with required authors */
        Set<Book> id_booksSet = findBooksDao.findBooksWithAuthors(authorsSet, strictly);

        Queue<Book> queue = new PriorityQueue<Book>();
        if(!strictly) {

            Map<Integer, List<Book>> map = new HashMap<Integer, List<Book>>();

            Iterator it = id_booksSet.iterator();
            int max_count = 0;
            while (it.hasNext()) {
                Book book = (Book) it.next();
                max_count = (book.getAuthors().size() > max_count) ? book.getAuthors().size() : max_count;
                if (map.containsKey(book.getAuthors().size())) {
                    List<Book> list = map.get(book.getAuthors().size());
                    list.add(book);
                } else {
                    List<Book> list = new ArrayList<Book>();
                    list.add(book);
                    map.put(book.getAuthors().size(), list);
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

    public Set<Book> findBooksWithPublishYear(int year) {
            return findBooksDao.findBooksWithPublishYear(year);
    }

    public Queue<Book> findBooksWithTags(String tags, boolean strictly) {

        /* Get the tags */
        StringTokenizer st = new StringTokenizer(tags, ",;");
        Set<String> tagsSet = new HashSet<String>(st.countTokens());

        while(st.hasMoreTokens()) {
            tagsSet.add(st.nextToken());
        }

        /* find the books with required tags */
        Set<Book> id_booksSet = findBooksDao.findBooksWithTags(tagsSet, strictly);

        Queue<Book> queue = new PriorityQueue<Book>();
        if(!strictly) {

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

    public Set<Book> findBooksWithPublishHouse(String publishHouse) {
        return findBooksDao.findBooksWithPublishHouse(publishHouse);
    }

    public Queue<Book> findBooksWithParams(Map<String, String> mapParams) {
    return null;
    }
}
