package mk.ukim.finki.emt.emtlab.service.application;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayBookViewDto;
import mk.ukim.finki.emt.emtlab.model.views.BookView;

import java.util.List;

public interface BookViewApplicationService {
    List<DisplayBookViewDto> findAll();
}
