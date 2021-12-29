package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class DatosProductoDTOResponse  implements Serializable {
    private String nombreProducto;
    private float precio;
    private String descripcion;

    public DatosProductoDTOResponse(String nombreProducto, float precio, String descripcion) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}
