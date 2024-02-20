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
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Detection of unauthenticated requests.
        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest()
                        .authenticated()
        )       // Handling of login-form.
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authentication")
                                .defaultSuccessUrl("/", true)
                                .permitAll()

//                .logout(logout -> )
    );
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        // In memory storage of 3 different user accounts.
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

