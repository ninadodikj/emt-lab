package mk.ukim.finki.emt.emtlab.service.domain.impl;

import mk.ukim.finki.emt.emtlab.model.views.BookView;
import mk.ukim.finki.emt.emtlab.repository.BookViewRepository;
import mk.ukim.finki.emt.emtlab.service.domain.BookViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookViewImpl implements BookViewService {

    private final BookViewRepository bookViewRepository;

    public BookViewImpl(BookViewRepository bookViewRepository) {
        this.bookViewRepository = bookViewRepository;
    }

    @Override
    public List<BookView> findAll() {
        return bookViewRepository.findAll();
    }
}
