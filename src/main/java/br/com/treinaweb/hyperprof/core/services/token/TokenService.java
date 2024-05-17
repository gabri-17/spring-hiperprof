package br.com.treinaweb.hyperprof.core.services.token;

public interface TokenService {
    
    // Token JWT
    String gerarAccessToken(String subject);
    String getSubjectDoAcessToken(String accessToken);
    String gerarRefreshToken(String subject);
    String getSubjectRefreshToken(String refreshToken);
    void invalidarTokens(String... tokens); /* Método que pode receber um número 
    indeterminado de argumentos.*/
    
}
