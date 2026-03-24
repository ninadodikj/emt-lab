package mk.ukim.finki.emt.emtlab.model.dto;

import mk.ukim.finki.emt.emtlab.model.enums.Category;
import mk.ukim.finki.emt.emtlab.model.enums.State;

public record BookFilter(
        Category category,
        State state,
        Long authorId,
        Boolean availableCopiesOnly
) {
}