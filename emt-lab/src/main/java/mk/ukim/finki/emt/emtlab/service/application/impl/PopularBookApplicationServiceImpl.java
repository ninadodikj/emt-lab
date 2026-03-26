package mk.ukim.finki.emt.emtlab.service.application.impl;

import mk.ukim.finki.emt.emtlab.model.views.PopularBooksView;
import mk.ukim.finki.emt.emtlab.repository.PopularBookViewRepository;
import mk.ukim.finki.emt.emtlab.service.application.PopularAuthorViewApplicationService;
import mk.ukim.finki.emt.emtlab.service.application.PopularBookViewApplicationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PopularBookApplicationServiceImpl implements PopularBookViewApplicationService {

    private final PopularBookViewRepository  popularBookViewRepository;


    public PopularBookApplicationServiceImpl(PopularBookViewRepository popularBookViewRepository) {
        this.popularBookViewRepository = popularBookViewRepository;
    }

    @Override
    public Optional<PopularBooksView> findMostPopular() {
        return popularBookViewRepository.findTopByOrderByRentCountDesc();
    }
}
