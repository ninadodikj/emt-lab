package mk.ukim.finki.emt.emtlab.model.dto;

import mk.ukim.finki.emt.emtlab.model.domain.Book;
import mk.ukim.finki.emt.emtlab.model.enums.Category;
import mk.ukim.finki.emt.emtlab.model.enums.State;

import java.util.List;

public record DisplayBookDto(
        Long id,
        String name,
        Category category,
        Long authorId,
        State state,
        Integer availableCopies
) {
    public static DisplayBookDto from(Book book){
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                book.getAuthor().getId(),
                book.getState(),
                book.getAvailableCopies()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books){
        return books
                .stream()
                .map(DisplayBookDto::from)
                .toList();
    }
}
