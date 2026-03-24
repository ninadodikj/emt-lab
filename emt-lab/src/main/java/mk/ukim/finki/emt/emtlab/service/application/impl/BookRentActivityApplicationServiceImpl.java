package mk.ukim.finki.emt.emtlab.service.application.impl;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayBookRentActivityDto;
import mk.ukim.finki.emt.emtlab.service.application.BookRentActivityApplicationService;
import mk.ukim.finki.emt.emtlab.service.domain.BookRentActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentActivityApplicationServiceImpl implements BookRentActivityApplicationService {

    private final BookRentActivityService bookRentActivityService;

    public BookRentActivityApplicationServiceImpl(BookRentActivityService bookRentActivityService) {
        this.bookRentActivityService = bookRentActivityService;
    }

    @Override
    public List<DisplayBookRentActivityDto> findAll() {
        return DisplayBookRentActivityDto.from(bookRentActivityService.findAll());
    }
}
