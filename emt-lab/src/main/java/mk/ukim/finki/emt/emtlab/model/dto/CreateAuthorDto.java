package mk.ukim.finki.emt.emtlab.model.dto;

import mk.ukim.finki.emt.emtlab.model.domain.Author;
import mk.ukim.finki.emt.emtlab.model.domain.Country;

public record CreateAuthorDto(
        String name,
        String surname,
        Long countryId
) {
    public Author toAuthor(Country country){
        return new Author(name,surname,country);
    }
}
