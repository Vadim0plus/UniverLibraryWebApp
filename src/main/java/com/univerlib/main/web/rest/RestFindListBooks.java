package com.univerlib.main.web.rest;

import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.FindBooksServiceReturnBooksObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/books")
public class RestFindListBooks {
    @Autowired
    FindBooksServiceReturnBooksObj findBooksServiceReturnBooksObj;

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET,produces = "application/json")
    public List<Book> listBooks(@PathVariable("bookId") long bookId) {
        List<Book> bookList = findBooksServiceReturnBooksObj.findBookWithID(bookId);
        return bookList;
    }
}