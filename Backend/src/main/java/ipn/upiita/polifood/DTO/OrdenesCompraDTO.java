package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrdenesCompraDTO implements Serializable {
    private int cantidad;
    private String nombreProducto;
}
