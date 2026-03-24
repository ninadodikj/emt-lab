package mk.ukim.finki.emt.emtlab.service.application.impl;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayBookViewDto;
import mk.ukim.finki.emt.emtlab.service.application.BookViewApplicationService;
import mk.ukim.finki.emt.emtlab.service.domain.BookViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookViewApplicationServiceImpl implements BookViewApplicationService {
    private final BookViewService bookViewService;

    public BookViewApplicationServiceImpl(BookViewService bookViewService) {
        this.bookViewService = bookViewService;
    }

    @Override
    public List<DisplayBookViewDto> findAll() {
        return DisplayBookViewDto.from(bookViewService.findAll());
    }
}
