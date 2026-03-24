package mk.ukim.finki.emt.emtlab.service.domain.impl;

import mk.ukim.finki.emt.emtlab.events.BookNotAvailableEvent;
import mk.ukim.finki.emt.emtlab.events.BookRentedEvent;
import mk.ukim.finki.emt.emtlab.model.domain.Book;
import mk.ukim.finki.emt.emtlab.model.dto.BookFilter;
import mk.ukim.finki.emt.emtlab.model.enums.State;
import mk.ukim.finki.emt.emtlab.model.projection.BookDetailedProjection;
import mk.ukim.finki.emt.emtlab.model.projection.BookProjection;
import mk.ukim.finki.emt.emtlab.repository.BookRepository;
import mk.ukim.finki.emt.emtlab.service.domain.BookService;
import mk.ukim.finki.emt.emtlab.specification.BookSpecification;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ApplicationEventPublisher publisher;

    public BookServiceImpl(BookRepository bookRepository, ApplicationEventPublisher publisher) {
        this.bookRepository = bookRepository;
        this.publisher = publisher;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return bookRepository
                .findById(id)
                .map((existingBook) -> {
                    existingBook.setName(book.getName());
                    existingBook.setCategory(book.getCategory());
                    existingBook.setAuthor(book.getAuthor());
                    existingBook.setState(book.getState());
                    existingBook.setAvailableCopies(book.getAvailableCopies());
                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        return bookRepository.findById(id)
                .map(book->{
                    if(book.getState() != State.BAD){
                        throw new RuntimeException("Cannot delete a book that is in GOOD state");
                    }
                    bookRepository.delete(book);
                    return book;
                });
    }

    @Override
    public Optional<Book> rentBook(Long id) {
        return bookRepository.findById(id)
                .map(book->{
                    if(book.getState() != State.GOOD){
                        throw new RuntimeException("Cannot rent a book that is in BAD state");
                    }
                    if(book.getAvailableCopies()==0){
                        publisher.publishEvent(new BookNotAvailableEvent(book));
                        throw new RuntimeException("No available copies for this book");
                    }
                    book.setAvailableCopies(book.getAvailableCopies()-1);
                    publisher.publishEvent(new BookRentedEvent(book));
                    return bookRepository.save(book);
                });
    }

    @Override
    public List<Book> filterBooks(Long a, Long b) {
        return bookRepository.findAllByIdBetween(a,b);
    }

    @Override
    public Page<Book> findAll(int page, int size, BookFilter filter) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name").and(Sort.by(Sort.Direction.ASC, "createdAt")));
        return bookRepository.findAll(BookSpecification.buildFrom(filter),pageable);
    }

    @Override
    public List<BookProjection> findAllProjection() {
        return bookRepository.findAllProjection();
    }

    @Override
    public Optional<BookDetailedProjection> findBookDetailedById(Long id) {
        return bookRepository.findBookDetailedById(id);
    }

    @Override
    public List<Book> findWithAuthorAndCountry() {
        return  bookRepository.findAllWithAuthorAndCountryBy();
    }

    @Override
    public Optional<Book> findWithAuthorAndCountryById(Long id) {
        return bookRepository.findWithAuthorAndCountryById(id);
    }

}
