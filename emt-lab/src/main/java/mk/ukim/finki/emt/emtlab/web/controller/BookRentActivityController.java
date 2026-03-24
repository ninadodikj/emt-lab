package mk.ukim.finki.emt.emtlab.web.controller;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayBookDto;
import mk.ukim.finki.emt.emtlab.model.dto.DisplayBookRentActivityDto;
import mk.ukim.finki.emt.emtlab.service.application.BookRentActivityApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book-activity")
public class BookRentActivityController {

    private final BookRentActivityApplicationService bookRentActivityApplicationService;

    public BookRentActivityController(BookRentActivityApplicationService bookRentActivityApplicationService) {
        this.bookRentActivityApplicationService = bookRentActivityApplicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DisplayBookRentActivityDto>> findAll() {
        return ResponseEntity.ok(bookRentActivityApplicationService.findAll());
    }
}
