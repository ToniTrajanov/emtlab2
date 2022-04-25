package mk.ukim.finki.emtlab193270.Service.impl;

import mk.ukim.finki.emtlab193270.Model.Country;
import mk.ukim.finki.emtlab193270.Repository.CountryRepository;
import mk.ukim.finki.emtlab193270.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findByName(String name) {
        return this.countryRepository.findByName(name);
    }
}