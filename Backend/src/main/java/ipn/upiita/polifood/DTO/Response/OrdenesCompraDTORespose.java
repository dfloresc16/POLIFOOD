package ipn.upiita.polifood.DTO.Response;

import lombok.Data;

@Data
public class OrdenesCompraDTORespose {
    private int cantidad;

    public OrdenesCompraDTORespose(int cantidad) {
        this.cantidad = cantidad;
    }
}
