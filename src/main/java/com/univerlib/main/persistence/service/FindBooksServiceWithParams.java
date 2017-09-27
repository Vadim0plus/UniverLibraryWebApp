package com.univerlib.main.persistence.service;

import com.univerlib.main.persistence.model.Book;

import java.util.List;
import java.util.Map;

public interface FindBooksServiceWithParams {
    List<Book> findBooksWithParams(Map<String,String> mapParams);
}
