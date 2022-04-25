package mk.ukim.finki.emtlab193270.Controller;


import mk.ukim.finki.emtlab193270.Model.Author;
import mk.ukim.finki.emtlab193270.Model.Book;
import mk.ukim.finki.emtlab193270.Model.Category;
import mk.ukim.finki.emtlab193270.Service.AuthorService;
import mk.ukim.finki.emtlab193270.Service.BookService;
import mk.ukim.finki.emtlab193270.Service.CategoryService;
import mk.ukim.finki.emtlab193270.Service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/","/books"})
public class BooksController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;
    private final CategoryService categoryService;



    public BooksController(BookService bookService, AuthorService authorService, CountryService countryService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getBookPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Book> books = this.bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("bodyContent", "books");
        return "index";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id){
        this.bookService.deleteById(id);
        return "redirect:/books";
    }
    @GetMapping("/{id}/edit-form")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.bookService.findById(id).isPresent()) {
            Book book=this.bookService.findById(id).get();
            List<Author> authors=this.authorService.findAll();
            List<Category> categories= this.categoryService.listCategories();
            model.addAttribute("authors", authors);
            model.addAttribute("categories", categories);
            model.addAttribute("book", book);
            model.addAttribute("bodyContent", "add-book");
            return "index";
        }
        return "redirect:/books?error=BookNotFound";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        List<Author> authors=this.authorService.findAll();
        List<Category> categories= this.categoryService.listCategories();
        model.addAttribute("authors", authors);
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "add-book");
        return "index";
    }

    @PostMapping("/add")
    public String saveBook(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam Long category,
            @RequestParam Long authorId,
            @RequestParam Integer availableCopies) {
        if (id != null) {
            this.bookService.edit(id,name,category,authorId,availableCopies);
        } else {
            this.bookService.save(name,category,authorId,availableCopies);
        }
        return "redirect:/books";
    }

}
