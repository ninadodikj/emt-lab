package mk.ukim.finki.emt.emtlab.service.application;



import mk.ukim.finki.emt.emtlab.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    Optional<DisplayCountryDto> findById(Long id);
    List<DisplayCountryDto> findAll();
}
