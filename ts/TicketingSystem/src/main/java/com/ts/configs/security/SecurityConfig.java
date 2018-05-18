package com.ts.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.google.common.collect.ImmutableList;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends BasedSecurityConfig {

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(ImmutableList.of("*"));
		configuration.setAllowedMethods(ImmutableList.of("HEAD",
				"GET", "POST", "PUT", "DELETE", "PATCH"));

		// setAllowCredentials(true) is important, otherwise:
		// The value of the 'Access-Control-Allow-Origin' header in the response must not
		// be the wildcard '*' when the request's credentials mode is 'include'.
		configuration.setAllowCredentials(true);
		// setAllowedHeaders is important! Without it, OPTIONS preflight request
		// will fail with 403 Invalid CORS request
		configuration.setAllowedHeaders(
				ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter
			extends WebSecurityConfigurerAdapter {

		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.cors()
			.and().
				sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.requestCache().requestCache(getHttpSessionRequestCache())
			.and()
             .requestMatchers()
                     .antMatchers("/ts/**")
                     .antMatchers("/health/**")
                     .antMatchers("/info/**")
                     .antMatchers("/autoconfig/**")
                     .antMatchers("/metrics/**")
                     .antMatchers("/trace/**")
                     .antMatchers("/loggers/**")
                     .antMatchers("/shutdown/**")
                     .antMatchers(HttpMethod.OPTIONS, "/**")
                     .and()
             .authorizeRequests()
                     .antMatchers("/health/**","/info/**","/metrics/**","/autoconfig/**","/trace/**","/loggers/**","/shutdown/**").hasRole("ADMIN")
                     .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //allow CORS option calls
			.and()
				.httpBasic().realmName("TicketingSystem");
			
			 // @formatter:on
		}

		public HttpSessionRequestCache getHttpSessionRequestCache() {
			HttpSessionRequestCache httpSessionRequestCache = new HttpSessionRequestCache();
			httpSessionRequestCache.setCreateSessionAllowed(false);
			return httpSessionRequestCache;
		}
	}

	@Configuration
	@Order(2)
	public static class FormWebSecurityConfigurationAdapter
			extends WebSecurityConfigurerAdapter {
		@Autowired
		private LoggingAccessDeniedHandler accessDeniedHandler;

		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			
			http.csrf().disable();
			http.headers().frameOptions().disable(); // this is to open the h2 console
			
			http
	        .authorizeRequests()
	            .antMatchers(
	                    "/",
	                    "/js/**",
	                    "/css/**",
	                    "/img/**",
	                    "/webjars/**").permitAll()
	            .antMatchers("/console/**","/swagger*/**").hasRole("ADMIN")
	            .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginPage("/login")
	            .permitAll()
	        .and()
	        .logout()
	            .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .logoutSuccessUrl("/login?logout")
	            .permitAll()
	        .and()
	        .exceptionHandling()
	            .accessDeniedHandler(accessDeniedHandler);
			// @formatter:on
		}
	}
}