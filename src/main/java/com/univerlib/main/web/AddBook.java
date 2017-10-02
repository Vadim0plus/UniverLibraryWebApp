package com.univerlib.main.web;

import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/addbook")
public class AddBook {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String add( @RequestParam("authors") String authors,
                       @RequestParam("name") String name,
                       @RequestParam("tags") String tags,
                       @RequestParam("year") String year,
                       @RequestParam("num") Long num,
                       @RequestParam("desc") String desc,
                       @RequestParam("publishDate") Date publishDate,
                       @RequestParam("publishHouse") String publishHouse,
                       ModelMap model) {

        Book newBook = new Book(0,num,name,desc,publishDate,publishHouse);
        newBook = bookService.addBook(newBook);
        if(newBook != null) {
            model.addAttribute("addedBook", newBook);
            return "addBookForm";
        }
        else {
            return "addBookForm";
        }
    }
    }
