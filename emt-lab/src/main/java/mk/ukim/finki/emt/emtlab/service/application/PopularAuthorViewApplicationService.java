package mk.ukim.finki.emt.emtlab.service.application;

import mk.ukim.finki.emt.emtlab.model.views.PopularAuthorView;

import java.util.Optional;

public interface PopularAuthorViewApplicationService {
    Optional<PopularAuthorView> findMostPopular();

}
