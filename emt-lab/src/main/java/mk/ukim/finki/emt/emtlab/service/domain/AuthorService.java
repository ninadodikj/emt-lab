package mk.ukim.finki.emt.emtlab.service.domain;

import mk.ukim.finki.emt.emtlab.model.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AuthorService{

    Optional<Author> findById(Long id);

    List<Author> findAll();

    Author create(Author author);

    Optional<Author> update(Long id,Author author);

    Optional<Author> deleteById(Long id);

}
