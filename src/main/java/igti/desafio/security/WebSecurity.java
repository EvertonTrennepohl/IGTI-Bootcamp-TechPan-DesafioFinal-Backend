package igti.desafio.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import igti.desafio.service.ClienteDetailServiceImpl;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private final ClienteDetailServiceImpl clienteDetailsService;
	
	public WebSecurity(ClienteDetailServiceImpl clienteDetailsService) {
		this.clienteDetailsService = clienteDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, SecurityConstants.STATUS_URL)
		.permitAll()
		.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(clienteDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		
		// 1. Define estritamente quais origens têm permissão de acessar os dados
		// (Mantenha a URL da Vercel e o localhost para testes locais)
		configuration.setAllowedOrigins(java.util.List.of(
			"https://ngfood.vercel.app", 
			"http://localhost:4200"
		));
		
		// 2. Libera explicitamente os métodos HTTP utilizados pelo Angular
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
		
		// 3. Permite os cabeçalhos de autenticação necessários para o transporte do JWT
		configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
		
		// 4. OBRIGATÓRIO: Autoriza o recebimento do token enviado pelo interceptor do front-end
		configuration.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
