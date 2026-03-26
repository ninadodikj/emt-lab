package mk.ukim.finki.emt.emtlab.web.controller;
import mk.ukim.finki.emt.emtlab.model.views.PopularAuthorView;
import mk.ukim.finki.emt.emtlab.model.views.PopularBooksView;
import mk.ukim.finki.emt.emtlab.service.application.PopularAuthorViewApplicationService;
import mk.ukim.finki.emt.emtlab.service.application.PopularBookViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/most-popular")
public class PopularBookAndAuthorController {

    private final PopularAuthorViewApplicationService popularAuthorViewApplicationService;
    private final PopularBookViewApplicationService popularBookViewApplicationService;

    public PopularBookAndAuthorController(PopularAuthorViewApplicationService popularAuthorViewApplicationService, PopularBookViewApplicationService popularBookViewApplicationService) {
        this.popularAuthorViewApplicationService = popularAuthorViewApplicationService;
        this.popularBookViewApplicationService = popularBookViewApplicationService;
    }

    @GetMapping("/author")
    public ResponseEntity<PopularAuthorView> findPopularAuthor() {
        return ResponseEntity.ok(popularAuthorViewApplicationService.findMostPopular().orElseThrow());
    }
    @GetMapping("/book")
    public ResponseEntity<PopularBooksView> findPopularBook() {
        return ResponseEntity.ok(popularBookViewApplicationService.findMostPopular().orElseThrow());
    }

}
