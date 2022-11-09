package Sopra.DiscuissonAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		return http.antMatcher("/**")
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.POST ,"/api/user/inscription").anonymous()
				.antMatchers(HttpMethod.PATCH,"/api/user/**").authenticated()
				.antMatchers(HttpMethod.POST, "/api/message/**").hasAnyRole("USER","NUTRITIONIST")
				.antMatchers(HttpMethod.POST, "/api/nutritionist/**").hasAnyRole("NUTRITIONIST","ADMIN")
				.antMatchers(HttpMethod.POST, "/api/ingredient/**").permitAll()	//rajouter sécurité voir/edit
				.antMatchers(HttpMethod.POST, "/api/recette/**").permitAll()	//rajouter sécurité voir/edit
				.antMatchers(HttpMethod.POST, "/api/ingredient/**").permitAll()	//rajouter sécurité voir/edit
				.antMatchers(HttpMethod.POST, "/api/recette/**").permitAll()	//rajouter sécurité voir/edit
				.anyRequest().hasRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.build();
		// @formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
