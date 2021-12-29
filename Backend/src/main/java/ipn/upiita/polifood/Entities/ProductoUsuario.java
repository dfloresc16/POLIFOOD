package ipn.upiita.polifood.Entities;

import ipn.upiita.polifood.DTO.ProductoJoinDatosDTOResponse;
import ipn.upiita.polifood.DTO.ProductoUsuarioDTOResponse;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(
        name ="ProductoJoindatosDTOResponse", classes={
        @ConstructorResult(targetClass = ProductoJoinDatosDTOResponse.class, columns = {
                @ColumnResult(name = "id_datos"),
                @ColumnResult(name = "id_producto_fk"),
                @ColumnResult(name = "nombre_producto"),
                @ColumnResult(name = "precio"),
                @ColumnResult(name = "descripcion"),
                @ColumnResult(name = "id_producto"),
                @ColumnResult(name = "id_usuario_fk")
        }),
}


)

@SqlResultSetMapping(
        name = "ProductoUsuarioDTOResponse", classes = {
        @ConstructorResult(targetClass = ProductoUsuarioDTOResponse.class, columns = {
                @ColumnResult(name = "id_producto"),
                @ColumnResult(name = "id_usuario_fk")
        }),
}
)

@NamedStoredProcedureQueries(
        {
        @NamedStoredProcedureQuery(

                name = "insertarProductoUsuario",
                procedureName = "sp_insertarProductoUsuario",resultSetMappings = "ProductoUsuarioDTOResponse",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo",type = String.class)
                                       }
        ),
                 @NamedStoredProcedureQuery(
                         name = "borrarProductoJoindatos",
                         procedureName = "sp_borrarProducto",resultSetMappings = "ProductoJoindatosDTOResponse",
                         parameters = {
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idProducto",type = Integer.class),
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correoInsititucional",type = String.class),

                         }
                 )


})

@Data
@Entity
@Table(name = "Productos")
public class ProductoUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idPorducto;

    @Column(name="id_usuario_fk")
    private int id_usuario_fk;

    @OneToOne
    @JoinColumn(name = "id_usuario_fk", insertable = false,updatable = false)
    private Usuario usuario;


    public ProductoUsuario() {
    }

    public ProductoUsuario(Usuario usuario, int id_usuario_fk){
        this.usuario=usuario;
        this.id_usuario_fk=id_usuario_fk;


    }

}
