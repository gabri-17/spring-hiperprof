package br.com.treinaweb.hyperprof.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// Configuração componentizada (Spring Security utiliza).
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                /*
                 * Basicamente, está permitindo que todas as rotas possam ser acessadas sem
                 * necessariamente ser autenticadas.
                 */
                http
                                .authorizeHttpRequests(customizer -> customizer
                                                .anyRequest().permitAll())
                                .csrf(customizer -> customizer
                                                .disable())
                                .sessionManagement(customizer -> customizer
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

                return http.build();

                /*
                 * Requisições POST não podem funcionar perante um csrf token
                 * (trabalhando com API).
                 * - Com API as requisições devem ser stateless( não guardar estados).
                 */

        }

        // Criar um Bean Spring (método que vai gerar do AuthenticationManager)
        @Bean // Pode injetar authenticationManager em outros beans Spring.
        public AuthenticationManager authenticationManager(
                        AuthenticationConfiguration authenticationConfiguration) throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }
}
