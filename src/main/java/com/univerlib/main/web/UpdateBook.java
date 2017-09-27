package com.univerlib.main.web;

import com.univerlib.main.persistence.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/updatebook")
public class UpdateBook {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("authors") String authors,
            @RequestParam("name") String name,
            @RequestParam("tags") String tags,
            @RequestParam("year") String year,
            @RequestParam("num") Long num,
            @RequestParam("desc") String desc,
            @RequestParam("publishDate") Date publishDate,
            @RequestParam("publishHouse") String publishHouse,
            ModelMap model) {

        Book updatedBook = new Book(id,num,name,desc,publishDate,publishHouse);
        updatedBook = bookService.updateBook(updatedBook);
        if(updatedBook != null) {
            model.addAttribute("updatedBook", updatedBook);
            return "updateBook";
        }
        else {
            return "updateBook";
        }
    }
}
