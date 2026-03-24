package mk.ukim.finki.emt.emtlab.service.application;

import mk.ukim.finki.emt.emtlab.model.dto.BookFilter;
import mk.ukim.finki.emt.emtlab.model.dto.CreateBookDto;
import mk.ukim.finki.emt.emtlab.model.dto.DisplayBookDto;
import mk.ukim.finki.emt.emtlab.model.projection.BookDetailedProjection;
import mk.ukim.finki.emt.emtlab.model.projection.BookProjection;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {

    Optional<DisplayBookDto> findById(Long id);
    List<DisplayBookDto> findAll();

    DisplayBookDto create(CreateBookDto createBookDto);

    Optional<DisplayBookDto> update(Long id,CreateBookDto createBookDto);

    Optional<DisplayBookDto> deleteById(Long id);

    Optional<DisplayBookDto> rentBook(Long id);

    List<DisplayBookDto> filterBooks(Long a,Long b);

    Page<DisplayBookDto> findAll(int page, int size, BookFilter filter);

    List<BookProjection>  findAllProjection();
    Optional<BookDetailedProjection> findBookDetailedById(Long id);

    List<DisplayBookDto> findWithAuthorAndCountry();
    Optional<DisplayBookDto> findWithAuthorAndCountryById(Long id);

}
