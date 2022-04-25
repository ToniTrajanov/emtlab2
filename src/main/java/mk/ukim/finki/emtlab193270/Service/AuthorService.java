package mk.ukim.finki.emtlab193270.Service;

import mk.ukim.finki.emtlab193270.Model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> findByFullName(String name, String surname);
}
