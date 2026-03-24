package mk.ukim.finki.emt.emtlab.model.dto;

import mk.ukim.finki.emt.emtlab.model.enums.Category;
import mk.ukim.finki.emt.emtlab.model.enums.State;
import mk.ukim.finki.emt.emtlab.model.views.BookView;

import java.util.List;

public record DisplayBookViewDto(
        String name,
        Category category,
        State state,
        Integer availableCopies,
        String authorFullName,
        String countryName
) {
    public static DisplayBookViewDto from(BookView bookView) {
        return new DisplayBookViewDto(
                bookView.getName(),
                bookView.getCategory(),
                bookView.getState(),
                bookView.getAvailableCopies(),
                bookView.getAuthorFullName(),
                bookView.getCountryName()
        );
    }
    public static List<DisplayBookViewDto> from (List<BookView> bookViews) {
        return bookViews
                .stream()
                .map(DisplayBookViewDto::from)
                .toList();
    }
}
