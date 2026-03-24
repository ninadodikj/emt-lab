package mk.ukim.finki.emt.emtlab.model.projection;

import mk.ukim.finki.emt.emtlab.model.enums.Category;
import mk.ukim.finki.emt.emtlab.model.enums.State;

public interface BookDetailedProjection {
    Long getId();
    String getName();
    Category getCategory();
    State getState();
    Integer getAvailableCopies();
    String getAuthorName();
    String getAuthorSurname();
    String getCountryName();
}
