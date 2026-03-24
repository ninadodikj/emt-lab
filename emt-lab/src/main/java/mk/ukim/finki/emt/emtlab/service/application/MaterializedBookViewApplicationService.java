package mk.ukim.finki.emt.emtlab.service.application;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayMaterializedBookViewDto;

import java.util.List;

public interface MaterializedBookViewApplicationService {

    List<DisplayMaterializedBookViewDto> findAll();
}
