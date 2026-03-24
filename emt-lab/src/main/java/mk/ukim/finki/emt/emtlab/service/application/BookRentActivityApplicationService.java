package mk.ukim.finki.emt.emtlab.service.application;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayBookRentActivityDto;

import java.util.List;

public interface BookRentActivityApplicationService {
    List<DisplayBookRentActivityDto> findAll();
}
