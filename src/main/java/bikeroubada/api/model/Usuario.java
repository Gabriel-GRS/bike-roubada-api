package bikeroubada.api.model;

import bikeroubada.api.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Table(name="usuarios")
@Entity(name="usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    
    public Usuario(UsuarioDTO usuario) {
        this.nome = usuario.nome();
        this.cpf = usuario.cpf();
        this.email = usuario.email();
        this.idade = usuario.idade();
        this.numeroTelefone = usuario.numeroTelefone();
        this.sexo = usuario.sexo();
        this.endereco = usuario.endereco();
        this.ativo = true;

    }
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String numeroTelefone;
    private String endereco;
    private String cpf;
    private char sexo;
    private LocalDate idade;
    private Boolean ativo;


    public void excluir() {
        this.ativo = false;
    }
}
