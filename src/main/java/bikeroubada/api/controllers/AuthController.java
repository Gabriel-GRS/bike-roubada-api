package bikeroubada.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bikeroubada.api.dto.AuthDTO;
import bikeroubada.api.dto.TokenJWTDTO;
import bikeroubada.api.model.UsuarioLogin;
import bikeroubada.api.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> doLogin(@RequestBody @Valid AuthDTO dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication =  manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((UsuarioLogin) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTDTO(tokenJWT));
    }

}
