package mk.ukim.finki.emt.emtlab.service.domain;

import mk.ukim.finki.emt.emtlab.model.views.MaterializedBookView;

import java.util.List;

public interface MaterializedBookViewService {
    List<MaterializedBookView> findAll();
}
