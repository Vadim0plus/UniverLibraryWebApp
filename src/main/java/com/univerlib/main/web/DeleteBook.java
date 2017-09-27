package com.univerlib.main.web;

import com.univerlib.main.persistence.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/deletebook")
public class DeleteBook {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String remove(@RequestParam("id") Long id,
                         ModelMap modelMap) {
        Book deletedBook = bookService.removeBook(id);
        if(deletedBook != null) {
            modelMap.addAttribute("NameDeletedBook", deletedBook.getName());
            return "deleteBook";
        }
        else
        {
            return "deleteBook";
        }
    }
}
