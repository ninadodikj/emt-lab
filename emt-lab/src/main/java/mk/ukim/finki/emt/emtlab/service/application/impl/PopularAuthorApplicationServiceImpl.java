package mk.ukim.finki.emt.emtlab.service.application.impl;

import mk.ukim.finki.emt.emtlab.model.views.PopularAuthorView;
import mk.ukim.finki.emt.emtlab.repository.PopularAuthorViewRepository;
import mk.ukim.finki.emt.emtlab.service.application.PopularAuthorViewApplicationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PopularAuthorApplicationServiceImpl implements PopularAuthorViewApplicationService {

    private final PopularAuthorViewRepository popularAuthorViewRepository;

    public PopularAuthorApplicationServiceImpl(PopularAuthorViewRepository popularAuthorViewRepository) {
        this.popularAuthorViewRepository = popularAuthorViewRepository;
    }

    @Override
    public Optional<PopularAuthorView> findMostPopular() {
        return popularAuthorViewRepository.findTopByOrderByRentCountDesc();
    }
}
