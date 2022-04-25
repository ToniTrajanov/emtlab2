package mk.ukim.finki.emtlab193270.Service.impl;

import mk.ukim.finki.emtlab193270.Model.Author;
import mk.ukim.finki.emtlab193270.Model.Book;
import mk.ukim.finki.emtlab193270.Model.Category;
import mk.ukim.finki.emtlab193270.Model.Exceptions.AuthorNotFoundException;
import mk.ukim.finki.emtlab193270.Model.Exceptions.BookNotFoundException;
import mk.ukim.finki.emtlab193270.Model.Exceptions.CategoryNotFoundException;
import mk.ukim.finki.emtlab193270.Repository.AuthorRepository;
import mk.ukim.finki.emtlab193270.Repository.BookRepository;
import mk.ukim.finki.emtlab193270.Repository.CategoryRepository;
import mk.ukim.finki.emtlab193270.Service.AuthorService;
import mk.ukim.finki.emtlab193270.Service.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, Long category, Long authorId, Integer availableCopies) {
        Author author=this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException());
        Category category1=this.categoryRepository.findById(category).orElseThrow(()->new CategoryNotFoundException());
        this.bookRepository.deleteByName(name);
        return Optional.of(this.bookRepository.save(new Book(name,category1,author,availableCopies)));
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, Long category, Long authorId, Integer availableCopies) {
        Book book=this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException());
        book.setName(name);
        Category category1=this.categoryRepository.findById(category).orElseThrow(()->new CategoryNotFoundException());
        book.setCategory(category1);
        Author author=this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException());
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }





}
