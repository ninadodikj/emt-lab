package mk.ukim.finki.emt.emtlab.service.domain;

import mk.ukim.finki.emt.emtlab.model.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    Book create(Book book);

    Optional<Book> update(Long id,Book book);

    Optional<Book> deleteById(Long id);

    Optional<Book> rentBook(Long id);

    List<Book> filterBooks(Long a,Long b);

}
