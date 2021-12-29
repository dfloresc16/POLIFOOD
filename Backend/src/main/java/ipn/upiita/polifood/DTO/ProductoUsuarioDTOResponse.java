package ipn.upiita.polifood.DTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoUsuarioDTOResponse implements Serializable{
    private int idProducto;
    private int id_usuario_fk;


    public ProductoUsuarioDTOResponse(int idProducto, int id_usuario_fk) {
        this.idProducto= idProducto;
        this.id_usuario_fk = id_usuario_fk;

    }
}
