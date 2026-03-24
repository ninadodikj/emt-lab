package mk.ukim.finki.emt.emtlab.events;

import mk.ukim.finki.emt.emtlab.model.domain.Book;

public record BookRentedEvent(Book book) {
}
