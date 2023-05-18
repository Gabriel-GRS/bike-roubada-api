package bikeroubada.api.dto;


import bikeroubada.api.model.Bike;

public record ListagemBikeDTO(Long id, String marca, Integer chassi, String cor) {
    
    public ListagemBikeDTO(Bike bike) {
        this(bike.getId(), bike.getMarca(), bike.getChassi(), bike.getCor());
    }
}
