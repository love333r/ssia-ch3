package com.example.ssiach3.model;

import lombok.Data;

@Data
public class UserDto {
    private String userId;
    private String pwdHshCd;
    private String userNm;
    private String email;
    private String userFl;
    private String authority;

}
