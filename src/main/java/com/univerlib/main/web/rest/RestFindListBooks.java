package com.univerlib.main.web.rest;

import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.FindBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/books")
public class RestFindListBooks {
    @Autowired
    FindBooksService findBooksService;

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET,produces = "application/json")
    public List<Book> listBooks(@PathVariable("bookId") long bookId) {
        List<Book> bookList = findBooksService.findBookWithID(bookId);
        return bookList;
    }
}