package bikeroubada.api.dto;

import bikeroubada.api.model.Usuario;

public record ListagemUsuarioDTO(Long id, String nome, String email, String cpf, int idade, char sexo, String endereco) {
    
    public ListagemUsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf(), usuario.getIdade(), usuario.getSexo(), usuario.getEndereco());
    }
}
