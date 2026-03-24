package mk.ukim.finki.emt.emtlab.service.domain;

import mk.ukim.finki.emt.emtlab.model.views.BookView;

import java.util.List;

public interface BookViewService {
    List<BookView> findAll();
}
