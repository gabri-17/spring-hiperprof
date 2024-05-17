package br.com.treinaweb.hyperprof.core.services.token.providers.jjwt;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import br.com.treinaweb.hyperprof.core.services.token.TokenService;
import br.com.treinaweb.hyperprof.core.services.token.TokenServiceException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JjwtTokenService implements TokenService {

    private final JjwtConfigProperties configProperties;

    @Override
    public String gerarAccessToken(String subject) {

        return gerarToken(
                subject,
                configProperties.getAccessTokenExpirationInSeconds(),
                configProperties.getAccessTokenSigningKey());
    }

    @Override
    public String getSubjectDoAcessToken(String accessToken) {
        return getClaims(
                accessToken,
                configProperties.getAccessTokenSigningKey()).getSubject();
    }

    @Override
    public String gerarRefreshToken(String subject) {
        // TODO Auto-generated method stub
        return gerarToken(
                subject,
                configProperties.getRefreshTokenExpirationInSeconds(),
                configProperties.getRefreshTokenSigningKey());
    }

    @Override
    public String getSubjectRefreshToken(String refreshToken) {
        return getClaims(
                refreshToken,
                configProperties.getRefreshTokenSigningKey()).getSubject();
    }

    @Override
    public void invalidarTokens(String... tokens) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invalidarTokens'");
    }

    private String gerarToken(String subject, Long expirationInSeconds, String signingKey) {
        var dataHoraAtual = Instant.now();
        var dataHoraExpiracao = dataHoraAtual.plusSeconds(expirationInSeconds);
        return Jwts.builder()
                .setClaims(new HashMap<String, Object>())
                .setSubject(subject)
                .setIssuedAt(Date.from(dataHoraAtual))
                .setExpiration(Date.from(dataHoraExpiracao))
                // Gerar um array de bytes relacionado a assinatura.
                .signWith(Keys.hmacShaKeyFor(signingKey.getBytes()))
                .compact(); // compactar e retornar uma string que vai ser token JWT.
    }

    private Claims getClaims(String token, String signingKey) {
        try {
            // Boa prática definida dentro do CLEAN CODE.
            return tryGetClaims(token, signingKey);

        } catch (Exception e) {
            throw new TokenServiceException(e.getLocalizedMessage());
        }
    }

    private Claims tryGetClaims(String token, String signingKey) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(signingKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
