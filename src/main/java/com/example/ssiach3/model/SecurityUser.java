package com.example.ssiach3.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private final UserDto user; // final 사용 이유: UserDto 객체가 반드시 필요

    public SecurityUser(UserDto user) {
        this.user = user;
    }
//    private final String username;
//    private final String password;
//    private final String authority;
//
//    public SecurityUser(String username, String password, String authority) {
//        this.username = username;
//        this.password = password;
//        this.authority = authority;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> user.getAuthority());
//        return List.of(() -> authority);
    }

    @Override
    public String getPassword() {
        return user.getPwdHshCd();
//        return password;
    }

    @Override
    public String getUsername() {
        return user.getUserId();
//        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
