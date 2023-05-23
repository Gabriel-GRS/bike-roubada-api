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

import bikeroubada.api.dto.ListagemBikeDTO;
import bikeroubada.api.dto.BikeDTO;
import bikeroubada.api.model.Bike;
import bikeroubada.api.repository.BikeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("bikes")
public class BikeController {

    @Autowired
    private BikeRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid BikeDTO dados) {
        repository.save(new Bike(dados));
    }

    @GetMapping
    public Page<ListagemBikeDTO> listar(
            @PageableDefault(size = 10, page = 0, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListagemBikeDTO::new);
    }

}
