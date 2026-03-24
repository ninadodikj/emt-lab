package mk.ukim.finki.emt.emtlab.service.domain;

import mk.ukim.finki.emt.emtlab.model.domain.Book;
import mk.ukim.finki.emt.emtlab.model.dto.BookFilter;
import mk.ukim.finki.emt.emtlab.model.projection.BookDetailedProjection;
import mk.ukim.finki.emt.emtlab.model.projection.BookProjection;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
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
    Page<Book> findAll(int page, int size, BookFilter filter);

    List<BookProjection>  findAllProjection();
    Optional<BookDetailedProjection>  findBookDetailedById(Long id);

    List<Book> findWithAuthorAndCountry();
    Optional<Book> findWithAuthorAndCountryById(Long id);

}
