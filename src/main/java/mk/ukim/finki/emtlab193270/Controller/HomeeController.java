package mk.ukim.finki.emtlab193270.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/books"})
public class HomeeController {

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("bodyContent", "index");
        return "master-template";
    }

    @GetMapping("/categories")
    public String getCategoriesPage(Model model){
        model.addAttribute("bodyContent", "categories");
        return "master-template";
    }
}
