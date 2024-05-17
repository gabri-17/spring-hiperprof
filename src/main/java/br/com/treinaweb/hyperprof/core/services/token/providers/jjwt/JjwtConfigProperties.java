package br.com.treinaweb.hyperprof.core.services.token.providers.jjwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data // Criar os métodos getters e setters para os atributos.
@Configuration // classe de configuração do Spring.

@ConfigurationProperties(prefix = "br.com.treinaweb.hyperprof.core.services.token.jjwt") // Prefixo da chave de
                                                                                         // configuração.
/*
 * Associação da classe jjwtConfigProperties com as chaves que possuem o
 * prefixo "br.com.treinaweb.hyperprof.core.services.token.jjwt"
 */
public class JjwtConfigProperties {
    // Atributos da classe como sendo as propriedades de configuração.
    private String accessTokenSigningKey;
    private String refreshTokenSigningKey;
    private Long accessTokenExpirationInSeconds;
    private Long refreshTokenExpirationInSeconds;
}
