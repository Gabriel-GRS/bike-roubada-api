package bikeroubada.api.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import bikeroubada.api.model.UsuarioLogin;
import lombok.*;

@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UsuarioLogin usuario) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                            .withIssuer("API bikeroubada.api")
                            .withSubject(usuario.getLogin())
                            .withExpiresAt(expirationDate())
                            .sign(algorithm);
        } catch(JWTCreationException exception) {
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }


    public Instant expirationDate() {
       return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")); 
    }
}
