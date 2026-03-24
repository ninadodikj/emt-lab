package mk.ukim.finki.emt.emtlab.events;

import mk.ukim.finki.emt.emtlab.model.domain.Book;

public record BookNotAvailableEvent(Book book) {
}
