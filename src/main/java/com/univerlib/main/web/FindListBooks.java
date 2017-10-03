package com.univerlib.main.web;
import com.univerlib.main.persistence.model.Book;
import com.univerlib.main.persistence.service.FindBooksServiceReturnBooksObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
@RequestMapping("/books")
public class FindListBooks {
    @Autowired
    FindBooksServiceReturnBooksObj findBooksServiceReturnBooksObj;

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public String listBooks(@PathVariable("bookId") long bookId, ModelMap model) {
        List<Book> bookList = findBooksServiceReturnBooksObj.findBookWithID(bookId);
        model.addAttribute("bookList",bookList);

        return "books";
    }
}