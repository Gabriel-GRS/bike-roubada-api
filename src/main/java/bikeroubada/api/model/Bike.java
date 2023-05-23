package bikeroubada.api.model;

import bikeroubada.api.dto.BikeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="bike")
@Entity(name="bike")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Bike {
    
    public Bike(BikeDTO bike) {
        this.marca = bike.marca();
        this.chassi = bike.chassi();
        this.cor = bike.cor();
    }
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private Integer chassi;
    private String cor;
    private boolean ativo;
  

    public void excluir() {
        this.ativo = false;
    }
}
