package mk.ukim.finki.emt.emtlab.web.controller;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayBookViewDto;
import mk.ukim.finki.emt.emtlab.service.application.BookViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book-view")
public class BookViewController {

    private final BookViewApplicationService bookViewApplicationService;

    public BookViewController(BookViewApplicationService bookViewApplicationService) {
        this.bookViewApplicationService = bookViewApplicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DisplayBookViewDto>> findAll() {
        return ResponseEntity.ok(bookViewApplicationService.findAll());
    }
}
