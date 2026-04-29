package mk.ukim.finki.emt.emtlab.model.dto;

import mk.ukim.finki.emt.emtlab.model.domain.User;

public record RegisterUserRequestDto(
        String name,
        String surname,
        String email,
        String username,
        String password
) {
    public User toUser() {
        return new User(name, surname, email, username, password);
    }
}
