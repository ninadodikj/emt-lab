package mk.ukim.finki.emt.emtlab.service.application;

import mk.ukim.finki.emt.emtlab.model.views.PopularBooksView;

import java.util.Optional;

public interface PopularBookViewApplicationService {

    Optional<PopularBooksView> findMostPopular();
}
