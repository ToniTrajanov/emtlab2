package mk.ukim.finki.emtlab193270.Service.impl;

import mk.ukim.finki.emtlab193270.Model.Author;
import mk.ukim.finki.emtlab193270.Repository.AuthorRepository;
import mk.ukim.finki.emtlab193270.Service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> findByFullName(String name, String surname) {
        return this.authorRepository.findByNameAndSurname(name, surname);
    }
}
