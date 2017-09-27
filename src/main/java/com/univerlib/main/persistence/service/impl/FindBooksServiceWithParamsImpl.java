package com.univerlib.main.persistence.service.impl;

import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.FindBooksServiceWithParams;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindBooksServiceWithParamsImpl extends FindBooksServiceWithParamImpl implements FindBooksServiceWithParams {
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
