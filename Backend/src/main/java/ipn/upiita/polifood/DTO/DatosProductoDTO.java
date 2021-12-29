package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class DatosProductoDTO implements Serializable {
    private String nombreProducto;
    private float precio;
    private String descripcion;
    private String correoInstitucional;

}
