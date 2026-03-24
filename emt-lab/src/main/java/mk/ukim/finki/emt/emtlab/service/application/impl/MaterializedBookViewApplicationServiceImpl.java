package mk.ukim.finki.emt.emtlab.service.application.impl;

import mk.ukim.finki.emt.emtlab.model.dto.DisplayMaterializedBookViewDto;
import mk.ukim.finki.emt.emtlab.service.application.MaterializedBookViewApplicationService;
import mk.ukim.finki.emt.emtlab.service.domain.MaterializedBookViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterializedBookViewApplicationServiceImpl implements MaterializedBookViewApplicationService {

    private final MaterializedBookViewService materializedBookViewService;

    public MaterializedBookViewApplicationServiceImpl(MaterializedBookViewService materializedBookViewService) {
        this.materializedBookViewService = materializedBookViewService;
    }

    @Override
    public List<DisplayMaterializedBookViewDto> findAll() {
        return DisplayMaterializedBookViewDto.from(materializedBookViewService.findAll());
    }
}
