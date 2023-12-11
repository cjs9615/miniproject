package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.pnu.config.filter.JWTAuthenticationFilter;
import edu.pnu.config.filter.JWTAuthorizationFilter;
import edu.pnu.persistence.MemberRepository;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedHeaders("*")
				.allowedMethods("*")
				.allowedOrigins("http://localhost:3000","http://127.0.0.1:3000")
				.exposedHeaders(HttpHeaders.AUTHORIZATION);
	}
	
//	public CorsConfigurationSource corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
////		config.addAllowedOrigin("http://127.0.0.1:3000"); // 교차를 허용할 Origin
////		config.addAllowedOrigin("http://localhost:3000"); // 교차를 허용할 Origin
//
//		config.addAllowedOriginPattern("*");
//		config.addAllowedMethod("*"); // 교차를 허용할 Method
//		config.addAllowedHeader("*"); // 교차를 허용할 Header
//		config.setAllowCredentials(true); // 요청/응답에 자격증명정보 포함을 허용
//		config.addExposedHeader(HttpHeaders.AUTHORIZATION);
//		
//		source.registerCorsConfiguration("/**", config); // 교차를 허용할 Origin의 URL
//		return source;
//	}
}
