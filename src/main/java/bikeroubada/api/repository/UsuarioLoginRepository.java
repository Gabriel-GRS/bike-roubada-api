package bikeroubada.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import bikeroubada.api.model.UsuarioLogin;

public interface UsuarioLoginRepository extends JpaRepository<UsuarioLogin, Long> {

    UserDetails findByLogin(String login);
    
}
