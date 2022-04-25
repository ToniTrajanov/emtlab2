package mk.ukim.finki.emtlab193270.Repository;

import mk.ukim.finki.emtlab193270.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
}
