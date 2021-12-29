package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoJoinDatos implements Serializable {
    private int id_datos;
    private int id_producto_fk;
    private String nombre_producto;
    private float precio;
    private String descripcion;
    private int id_producto;
    private int id_usuario_fk;
}
