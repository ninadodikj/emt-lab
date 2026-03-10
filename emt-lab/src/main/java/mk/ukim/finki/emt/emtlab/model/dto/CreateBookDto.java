package mk.ukim.finki.emt.emtlab.model.dto;

import jakarta.validation.constraints.Positive;
import mk.ukim.finki.emt.emtlab.model.domain.Author;
import mk.ukim.finki.emt.emtlab.model.domain.Book;
import mk.ukim.finki.emt.emtlab.model.enums.Category;
import mk.ukim.finki.emt.emtlab.model.enums.State;

import java.time.LocalDateTime;

public record CreateBookDto(
        String name,
        Category category,
        Long authorId,
        State state,
        @Positive
        Integer availableCopies
) {
    public Book toBook(Author author){
        return new Book(name,category,author,state,availableCopies);
    }
}
