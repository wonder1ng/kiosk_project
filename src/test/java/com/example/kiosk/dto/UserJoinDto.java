package com.example.kiosk.dto;

//                      @Controller @Service  @Repository
//html입력폼(react.js) <-> DTO <-> DTO <-> DAO(Repo) <-> DAO(Entity) <-> DB테이블
//  join form             JoinDto          IMemberRepo   MemberEntity    member
//  login form            LoginDto

import com.example.kiosk.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserJoinDto {
    @NotNull
    private Long id = Long.valueOf(0L);

    @Size(min=4, max=20, message = "아이디는 4자 이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String loginId;

    @Size(min=4, max=20, message = "암호는 4자 이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String password;

    @Size(min=8, max=13, message = "전화번호를 알맞게 입력해주세요.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String phoneNumber;

    private String faxNumber;

    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String company_name;

    private String branch;

    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    @Pattern(regexp = "^(ROLE_USER|ROLE_MAIN_USER|ROLE_BRANCH_USER)$",
            message = "ROLE_USER 또는 ROLE_ADMIN만 입력 가능합니다.")
    private String userRole;
    private String businessNumber;
    private String zipCode;
    private String streetAddress;
    private String detailAddress;

    private LocalDateTime createdAt;


}