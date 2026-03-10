package mk.ukim.finki.emt.emtlab.service.domain.impl;

import mk.ukim.finki.emt.emtlab.model.domain.Book;
import mk.ukim.finki.emt.emtlab.model.enums.State;
import mk.ukim.finki.emt.emtlab.repository.BookRepository;
import mk.ukim.finki.emt.emtlab.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
                        throw new RuntimeException("No available copies for this book");
                    }
                    book.setAvailableCopies(book.getAvailableCopies()-1);
                    return bookRepository.save(book);
                });
    }
}
