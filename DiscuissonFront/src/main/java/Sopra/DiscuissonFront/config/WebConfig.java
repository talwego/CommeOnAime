package perso.persoEshopSpringMVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import config.JpaConfig;

@Configuration
@EnableWebMvc
@ComponentScan({"perso.persoEshopSpringMVC.controller","perso.persoEshopSpringMVC.restcontroller"})
@Import(JpaConfig.class)
public class WebConfig {
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver uBVR = new UrlBasedViewResolver();
		uBVR.setViewClass(JstlView.class);
		uBVR.setPrefix("/WEB-INF/views/");
		uBVR.setSuffix(".jsp");
		return uBVR;
	}
}
