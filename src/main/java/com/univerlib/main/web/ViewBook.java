package com.univerlib.main.web;

import com.univerlib.main.persistence.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/viewbook")
public class ViewBook {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewBook(
            @RequestParam("id") Long id,
            ModelMap modelMap
    ) {

        Book book = bookService.viewBook(id);
        if(book != null) {
            modelMap.addAttribute("book", book);
            return "viewBook";
        }
        else
        {
            return "viewBook";
        }
    }
}
