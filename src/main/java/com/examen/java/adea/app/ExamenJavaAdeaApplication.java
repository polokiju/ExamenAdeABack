package com.examen.java.adea.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.examen.java.adea.app.security.JWTAuthorizationFilter;

@SpringBootApplication
public class ExamenJavaAdeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenJavaAdeaApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.anyRequest().authenticated();
		}
		
		  protected void registerAuthentication(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		        authManagerBuilder
		            .inMemoryAuthentication()
		                .withUser("login").password("password").roles("ADMIN");
		    }
	}

}
