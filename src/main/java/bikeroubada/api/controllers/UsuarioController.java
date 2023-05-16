package bikeroubada.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bikeroubada.api.dto.ListagemUsuarioDTO;
import bikeroubada.api.dto.UsuarioDTO;
import bikeroubada.api.model.Usuario;
import bikeroubada.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid UsuarioDTO dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public Page<ListagemUsuarioDTO> listar(
            @PageableDefault(size = 10, page = 0, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListagemUsuarioDTO::new);
    }

}
