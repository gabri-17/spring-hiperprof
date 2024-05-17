package br.com.treinaweb.hyperprof.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // Habilitar a auditoria.
public class AuditableConfig {
}
