package MindEase.MindEase.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer )
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("John")
                .password("{noop}test123")
                .roles("USER")
                .build();

        UserDetails suse = User.builder()
                .username("Susan")
                .password("{noop}pass123")
                .roles("USER", "THERAPIST")
                .build();

        UserDetails david = User.builder()
                .username("David")
                .password("{noop}dave123")
                .roles("USER", "THERAPIST", "ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(john, suse, david);
    }
}

