package mk.ukim.finki.emt.emtlab.service.application;

import mk.ukim.finki.emt.emtlab.model.dto.LoginUserRequestDto;
import mk.ukim.finki.emt.emtlab.model.dto.LoginUserResponseDto;
import mk.ukim.finki.emt.emtlab.model.dto.RegisterUserRequestDto;
import mk.ukim.finki.emt.emtlab.model.dto.RegisterUserResponseDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}

