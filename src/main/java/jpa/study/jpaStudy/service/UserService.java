package jpa.study.jpaStudy.service;

import jpa.study.jpaStudy.dto.UserDto;
import jpa.study.jpaStudy.entity.User;
import jpa.study.jpaStudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto save(UserDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .build();

        userRepository.save(user);

        return UserDto.from(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto updateById(Long id, UserDto dto) {
        User user = userRepository.findById(id).get();
        User updateUser = User.builder()
                .id(id)
                .name(dto.getName())
                .phone(user.getPhone())
                .createdDate(user.getCreatedDate())
                .build();

        userRepository.save(updateUser);

        return UserDto.from(updateUser);
    }
}
