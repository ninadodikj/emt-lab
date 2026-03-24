package mk.ukim.finki.emt.emtlab.service.domain.impl;

import mk.ukim.finki.emt.emtlab.model.domain.BookRentActivity;
import mk.ukim.finki.emt.emtlab.repository.BookRentActivityRepository;
import mk.ukim.finki.emt.emtlab.service.domain.BookRentActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentActivityServiceImpl implements BookRentActivityService {

    private final BookRentActivityRepository bookRentActivityRepository;

    public BookRentActivityServiceImpl(BookRentActivityRepository bookRentActivityRepository) {
        this.bookRentActivityRepository = bookRentActivityRepository;
    }

    @Override
    public List<BookRentActivity> findAll() {
        return bookRentActivityRepository.findAll();
    }
}
