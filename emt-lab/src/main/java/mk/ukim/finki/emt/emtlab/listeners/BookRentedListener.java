package mk.ukim.finki.emt.emtlab.listeners;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.emt.emtlab.events.BookNotAvailableEvent;
import mk.ukim.finki.emt.emtlab.events.BookRentedEvent;
import mk.ukim.finki.emt.emtlab.model.domain.BookRentActivity;
import mk.ukim.finki.emt.emtlab.model.enums.EventType;
import mk.ukim.finki.emt.emtlab.repository.BookRentActivityRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class BookRentedListener {

    private final BookRentActivityRepository bookRentActivityRepository;

    public BookRentedListener(BookRentActivityRepository bookRentActivityRepository) {
        this.bookRentActivityRepository = bookRentActivityRepository;
    }

    @EventListener
    public void onBookRented(BookRentedEvent event) {
        bookRentActivityRepository.save(new BookRentActivity(null,event.book().getId(),event.book().getName(), LocalDateTime.now(), EventType.RENTED));
        log.info("Book rented: id:{}, name:{}, availableCopies:{}", event.book().getId(), event.book().getName(), event.book().getAvailableCopies());
    }

    @EventListener
    public void onBookNotAvailable(BookNotAvailableEvent event) {
        bookRentActivityRepository.save(new BookRentActivity(null,event.book().getId(),event.book().getName(), LocalDateTime.now(), EventType.UNAVAILABLE));
        log.error("Book has no more available copies: id:{}, name:{}", event.book().getId(), event.book().getName());
    }
}
