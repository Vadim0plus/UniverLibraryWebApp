package com.univerlib.main.web.rest;

import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Date;

@RestController
@RequestMapping("/rest/")
public class RestAddBook {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "addbook", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Book> add( @RequestParam("authors") String authors,
                       @RequestParam("name") String name,
                       @RequestParam("tags") String tags,
                       @RequestParam("year") String year,
                       @RequestParam("num") Long num,
                       @RequestParam("desc") String desc,
                       @RequestParam("publishDate") Date publishDate,
                       @RequestParam("publishHouse") String publishHouse) {

        Book newBook = new Book(0,num,name,desc,publishDate,publishHouse);
        newBook = bookService.addBook(newBook);

        if(newBook != null) {
            ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(newBook,HttpStatus.CREATED);
            return responseEntity;
        }
        else {
            newBook = new Book();
            newBook.setId(new Long(0));
            ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(newBook,HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

    @RequestMapping(value = "deletebook", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Book> remove(@RequestParam("id") Long id) {
        Book deletedBook = new Book();
        deletedBook.setId(id);
        deletedBook = bookService.deleteBook(deletedBook);

        if(deletedBook != null) {
            ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(deletedBook,HttpStatus.OK);
            return responseEntity;
        }
        else {
            deletedBook = new Book();
            deletedBook.setId(new Long(0));
            ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(deletedBook,HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }
    @RequestMapping(value = "updatebook", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Book> update(
            @RequestParam("id") Long id,
            @RequestParam("authors") String authors,
            @RequestParam("name") String name,
            @RequestParam("tags") String tags,
            @RequestParam("year") String year,
            @RequestParam("num") Long num,
            @RequestParam("desc") String desc,
            @RequestParam("publishDate") Date publishDate,
            @RequestParam("publishHouse") String publishHouse) {

        Book updatedBook = new Book(id,num,name,desc,publishDate,publishHouse);
        updatedBook = bookService.updateBook(updatedBook);
        if(updatedBook != null) {
            ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(updatedBook,HttpStatus.OK);
            return responseEntity;
        }
        else {
            updatedBook = new Book();
            updatedBook.setId(new Long(0));
            ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(updatedBook,HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

    @RequestMapping(value = "viewbook", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Book> viewBook(@RequestParam("id") Long id) {
        Book book = new Book();
        book.setId(id);
        book = bookService.viewBook(book);
        if(book != null) {
            ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(book,HttpStatus.OK);
            return responseEntity;
        }
        else {
            book = new Book();
            book.setId(new Long(0));
            ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(book,HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

    }
