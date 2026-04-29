package mk.ukim.finki.emt.emtlab.service.application.impl;
import mk.ukim.finki.emt.emtlab.model.dto.DisplayCountryDto;
import mk.ukim.finki.emt.emtlab.service.application.CountryApplicationService;
import mk.ukim.finki.emt.emtlab.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;


    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService
                .findById(id)
                .map(DisplayCountryDto::from);
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryService.findAll());
    }
}
