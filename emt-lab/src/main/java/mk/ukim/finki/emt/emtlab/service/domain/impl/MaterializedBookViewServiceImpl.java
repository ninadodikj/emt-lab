package mk.ukim.finki.emt.emtlab.service.domain.impl;

import mk.ukim.finki.emt.emtlab.model.views.MaterializedBookView;
import mk.ukim.finki.emt.emtlab.repository.MaterializedBookViewRepository;
import mk.ukim.finki.emt.emtlab.service.domain.MaterializedBookViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterializedBookViewServiceImpl implements MaterializedBookViewService {
    private final MaterializedBookViewRepository materializedBookViewRepository;

    public MaterializedBookViewServiceImpl(MaterializedBookViewRepository materializedBookViewRepository) {
        this.materializedBookViewRepository = materializedBookViewRepository;
    }

    @Override
    public List<MaterializedBookView> findAll() {
        return materializedBookViewRepository.findAll();
    }
}
