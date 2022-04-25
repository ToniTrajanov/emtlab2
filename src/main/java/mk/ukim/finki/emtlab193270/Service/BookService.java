package mk.ukim.finki.emtlab193270.Service;


import mk.ukim.finki.emtlab193270.Model.Book;
import mk.ukim.finki.emtlab193270.Model.Category;

import java.util.*;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(String name, Long category, Long authorId, Integer availableCopies);
    Optional<Book> edit(Long id,String name, Long category, Long authorId, Integer availableCopies);
    void deleteById(Long id);



}


