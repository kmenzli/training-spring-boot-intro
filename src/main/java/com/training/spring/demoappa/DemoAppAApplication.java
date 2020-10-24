package com.training.spring.demoappa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class DemoAppAApplication {

	@Configuration
	static class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
					.passwordEncoder(NoOpPasswordEncoder.getInstance())
					.withUser("user").password("user").roles("USER")
					.and()
					.withUser("hero").password("hero").roles("USER", "HERO");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoAppAApplication.class, args);
	}

}
