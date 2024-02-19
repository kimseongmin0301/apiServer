package jpa.study.jpaStudy.dto;

import jpa.study.jpaStudy.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String phone;
    private Date createdDate;
    private Date updateDate;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhone())
                .createdDate(user.getCreatedDate())
                .updateDate(user.getUpdatedDate())
                .build();
    }

    public static UserDto from(Optional<User> user) {
        return UserDto.builder()
                .id(user.get().getId())
                .name(user.get().getName())
                .phone(user.get().getPhone())
                .createdDate(user.get().getCreatedDate())
                .updateDate(user.get().getUpdatedDate())
                .build();
    }
}
