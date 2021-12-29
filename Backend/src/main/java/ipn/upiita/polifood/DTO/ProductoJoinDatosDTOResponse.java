package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class ProductoJoinDatosDTOResponse implements Serializable {
    private int id_datos;
    private int id_producto_fk;
    private String nombre_producto;
    private float precio;
    private String descripcion;
    private int id_producto;
    private int id_usuario_fk;

    public ProductoJoinDatosDTOResponse(int id_datos, int id_producto_fk, String nombre_producto, float precio, String descripcion, int id_producto, int id_usuario_fk) {
        this.id_datos=id_datos;
        this.id_producto_fk=id_producto_fk;
        this.nombre_producto=nombre_producto;
        this.precio=precio;
        this.descripcion=descripcion;
        this.id_producto=id_producto;
        this.id_usuario_fk=id_usuario_fk;
    }


}
