package com.hopital.gateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class BasicAuthWebSecurityConfiguration 
{
	@Value("${spring.security.user.name}")
	private String userName;
	
	@Value("${spring.security.user.password}")
	private String userPassword;
	
	@Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
        return http
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .httpBasic().and().csrf().disable()
                .build();
    }
	
	@Bean
	   InMemoryUserDetailsManager userDetailsService() {
	    UserDetails user = User
	        .withUsername(this.userName)
	        .password(this.userPassword)
	        .roles("USER")
	        .build();
	    return new InMemoryUserDetailsManager(user);
	  }
}