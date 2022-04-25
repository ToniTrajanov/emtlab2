package mk.ukim.finki.emtlab193270.Service;

import mk.ukim.finki.emtlab193270.Model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findByName(String name);
}
