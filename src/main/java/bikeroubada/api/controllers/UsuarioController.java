package bikeroubada.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bikeroubada.api.dto.BikeDTO;
import bikeroubada.api.dto.ListagemUsuarioDTO;
import bikeroubada.api.dto.UsuarioDTO;
import bikeroubada.api.model.Bike;
import bikeroubada.api.model.Usuario;
import bikeroubada.api.repository.BikeRepository;
import bikeroubada.api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    private BikeRepository bikeRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid UsuarioDTO dados, @RequestBody List<BikeDTO> bikes) {
        Usuario usuario = repository.save(new Usuario(dados));
        for (BikeDTO bikeDTO : bikes) {
            Bike bike = new Bike(bikeDTO);
            if (usuario.getBikes() == null) {
                usuario.getBikes();
            }
            usuario.getBikes().add(bike);
        }
    }

    @GetMapping
    public Page<ListagemUsuarioDTO> listar(
            @PageableDefault(size = 10, page = 0, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListagemUsuarioDTO::new);
    }

    @PostMapping("/{usuarioId}/bicicletas")
    @Transactional
    public void adicionarBicicletaAoUsuario(@PathVariable Long usuarioId, @RequestBody BikeDTO bikeDTO) {
        Usuario usuario = repository.findById(usuarioId)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        
        Bike bike = new Bike(bikeDTO);
        bike.setUsuario(usuario);
        
        bikeRepository.save(bike);
    }

}
