package ipn.upiita.polifood.Entities;

import ipn.upiita.polifood.DTO.DatosProductoDTOResponse;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(
        name = "DatosProductoDTOResponse", classes = {
        @ConstructorResult(targetClass = DatosProductoDTOResponse.class, columns = {
                @ColumnResult(name = "nombre_producto"),
                @ColumnResult(name = "precio"),
                @ColumnResult(name = "descripcion")
        })
}
)

@NamedStoredProcedureQueries(
        {
                @NamedStoredProcedureQuery(
                        name = "insertarDatosProducto",
                        procedureName = "sp_insertarProducto",resultSetMappings = "DatosProductoDTOResponse",
                        parameters = {
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correoInstitucional",type = String.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreProducto",type = String.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_precio",type = float.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descripcion",type = String.class),

                        }),
               @NamedStoredProcedureQuery(
                        name = "borrarProductoUsuario",
                        procedureName = "sp_borrarProducto", resultSetMappings = "DatosProductoDTOResponse",
                        parameters = {
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreProducto", type = String.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correoInstitucional", type = String.class)
                        }),
               @NamedStoredProcedureQuery(
                       name = "listarProductos",
                       procedureName = "sp_listarProductos", resultSetMappings = "DatosProductoDTOResponse"
               ),
                @NamedStoredProcedureQuery(
                        name = "listarProductosPropios",
                        procedureName = "sp_listarProductosPropios",resultSetMappings = "DatosProductoDTOResponse",
                        parameters = {
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correoInstitucional", type = String.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_contrasenia", type = String.class)
                        })
        })

@Data
@Entity
@Table(name = "Datos_producto")
public class DatosProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_datos")
    private int id_datos;

    @Column(name = "id_producto_fk")
    private int id_usuario_fk;

    @Column(name = "nombre_producto")
    private String nombre_producto;

    @Column(name = "precio")
    private float precio;

    @Column(name = "descripcion")
    private  String descripcion;

    @OneToOne
    @JoinColumn(name = "id_usuario_fk", insertable = false,updatable = false)
    private Usuario usuario;

    public DatosProducto(int id_usuario_fk, String nombre_producto, float precio, String descripcion){
        this.id_usuario_fk = id_usuario_fk;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public DatosProducto(){

    }
}
