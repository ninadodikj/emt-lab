package mk.ukim.finki.emt.emtlab.model.dto;

import mk.ukim.finki.emt.emtlab.model.domain.BookRentActivity;
import mk.ukim.finki.emt.emtlab.model.enums.EventType;

import java.time.LocalDateTime;
import java.util.List;

public record DisplayBookRentActivityDto(
        Long bookId,
        String bookName,
        LocalDateTime rentedAt,
        EventType eventType
) {
    public static DisplayBookRentActivityDto from(BookRentActivity activity) {
        return new DisplayBookRentActivityDto(
                activity.getBookId(),
                activity.getBookName(),
                activity.getRentedAt(),
                activity.getEventType()
        );
    }
    public static List<DisplayBookRentActivityDto> from (List<BookRentActivity> bookRentActivities) {
        return bookRentActivities
                .stream()
                .map(DisplayBookRentActivityDto::from)
                .toList();
    }
}
