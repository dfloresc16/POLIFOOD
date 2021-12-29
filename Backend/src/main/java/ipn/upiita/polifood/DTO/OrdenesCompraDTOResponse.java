package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrdenesCompraDTOResponse implements Serializable {
    private int idCompra;
    private int cantidad;
    private int idUsuarioFk;
    private int idProductoFk;

    public OrdenesCompraDTOResponse(int idCompra, int cantidad, int idUsuarioFk, int idProductoFk) {
        this.idCompra = idCompra;
        this.cantidad = cantidad;
        this.idUsuarioFk = idUsuarioFk;
        this.idProductoFk = idProductoFk;
    }
}
