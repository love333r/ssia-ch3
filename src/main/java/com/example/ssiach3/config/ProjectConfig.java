package com.example.ssiach3.config;

import com.example.ssiach3.model.SecurityUser;
import com.example.ssiach3.model.UserDto;
import com.example.ssiach3.services.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;
import java.util.List;

@Configuration
public class ProjectConfig {

    // 사용자 등록
    @Bean
    public UserDetailsService userDetailsService () {
        UserDto user = new UserDto();
        user.setUserId("hrjeon");
        user.setPwdHshCd("1234");
        user.setAuthority("read");

//        UserDetails u = new SecurityUser("hrjeon", "1234", "read");
        UserDetails u = new SecurityUser(user);
        List<UserDetails> users = List.of(u);

        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
