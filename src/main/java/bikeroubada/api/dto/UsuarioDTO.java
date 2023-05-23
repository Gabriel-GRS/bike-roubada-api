package bikeroubada.api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UsuarioDTO(

@NotBlank String nome,
@NotBlank @Email String email,
@NotBlank String numeroTelefone,
@NotNull LocalDate idade,
@NotNull char sexo,
@NotBlank String endereco,
@NotBlank @Pattern(regexp="^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")
String cpf)
{

}
