package jp.co.who.spring_tutorial.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //String noneCheck = "/api";
        String noneCheck = "/echo";
        http.csrf().requireCsrfProtectionMatcher(request -> {
            if (request.getMethod().equals("GET"))
                return false;
            final boolean ret = request.getRequestURI().startsWith(noneCheck);
            return !ret;
        });
    }
}
