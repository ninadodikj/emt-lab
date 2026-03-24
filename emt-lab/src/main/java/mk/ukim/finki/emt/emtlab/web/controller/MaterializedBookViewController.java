package mk.ukim.finki.emt.emtlab.web.controller;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayMaterializedBookViewDto;
import mk.ukim.finki.emt.emtlab.service.application.MaterializedBookViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materialized-book-view")
public class MaterializedBookViewController {

    private final MaterializedBookViewApplicationService materializedBookViewApplicationService;

    public MaterializedBookViewController(MaterializedBookViewApplicationService materializedBookViewApplicationService) {
        this.materializedBookViewApplicationService = materializedBookViewApplicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DisplayMaterializedBookViewDto>> findAll() {
        return ResponseEntity.ok(materializedBookViewApplicationService.findAll());
    }
}
