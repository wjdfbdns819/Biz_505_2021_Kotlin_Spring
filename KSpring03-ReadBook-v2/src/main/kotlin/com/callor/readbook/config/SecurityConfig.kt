package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter () {

    override fun configure(http: HttpSecurity) {

        http.authorizeRequests()
                // meber에 mypage로 요청이 들어오면
            .antMatchers("/member/mypage").authenticated() // <- 인증을 받아야함
            .antMatchers("/**").permitAll()
            .mvcMatchers("/**").anonymous()

        // pop up login 창 띄우기
//        http.httpBasic()

        // 만약 인증이 필요한 페이지에 권한이 없이 접근하면
        // /member/login 으로 redirect 하라
        http.formLogin()
            .loginPage("/member/login").permitAll()
    }
}