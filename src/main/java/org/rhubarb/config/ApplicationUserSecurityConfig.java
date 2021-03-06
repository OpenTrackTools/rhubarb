package org.rhubarb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpan Mukhopadhyay
 */
@EnableWebSecurity
@Slf4j
public class ApplicationUserSecurityConfig {
  
  private static final String[] NON_SECURED_ENDPOINTS = new String[]{
      "/error",
      "/signin",
      "/signout",
      "/signup",
      //Dev endpoints
      "/h2-console/**"
  };
  
  private static final String[] WEB_RESOURCE_ENDPOINTS = new String[]{
      "/css/**",
      "/js/**",
      "/images/**",
      "/fonts/**",
      "/static/webfonts/**",
      "/favicon.ico"
  };
  
  @Bean
  PasswordEncoder delegatingPasswordEncoder() {
    Map<String, PasswordEncoder> encoders = new HashMap<>();
    Argon2PasswordEncoder defaultEncoder = new Argon2PasswordEncoder(16, 32, 1, 4096, 7);
    encoders.put("argon2id", defaultEncoder);
    DelegatingPasswordEncoder delegatingPasswordEncoder = new DelegatingPasswordEncoder("argon2id", encoders);
    delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);
    return delegatingPasswordEncoder;
  }
  
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.cors().and().csrf(csrf -> csrf.csrfTokenRepository(new CookieCsrfTokenRepository()))
        .authorizeHttpRequests((auth) -> auth.antMatchers(NON_SECURED_ENDPOINTS).permitAll()
            .antMatchers(WEB_RESOURCE_ENDPOINTS).permitAll().anyRequest().authenticated())
        .formLogin().loginPage("/signin").loginProcessingUrl("/signin").usernameParameter("login")
        .passwordParameter("password").and().logout(logout -> logout
            .logoutUrl("/signout")
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .deleteCookies("remove"));
    return http.build();
  }
}
