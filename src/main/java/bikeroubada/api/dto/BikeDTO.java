package bikeroubada.api.dto;
import jakarta.validation.constraints.NotBlank;


public record BikeDTO(

@NotBlank String marca,
@NotBlank Integer chassi,
@NotBlank String cor)
{

}
