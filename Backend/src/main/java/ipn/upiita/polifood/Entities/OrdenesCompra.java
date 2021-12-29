package ipn.upiita.polifood.Entities;

import ipn.upiita.polifood.DTO.Response.OrdenesCompraDTORespose;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(
        name = "OrdenesCompraDTOResponse", classes = {
                @ConstructorResult(targetClass = OrdenesCompraDTORespose.class, columns = {
                        @ColumnResult(name = "cantidad"),
                })
}
)

@NamedStoredProcedureQueries({
        /*@NamedStoredProcedureQuery(
                name = "insertarCompra",
                procedureName = "sp_insertarCompra",resultSetMappings = "OrdenesCompraDTOResponse",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cantidad",type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreProducto", type = String.class)
                }
        ),*/
        @NamedStoredProcedureQuery(
                name = "insertarCompra",
                procedureName = "sp_insertarCompra", resultSetMappings = "OrdenesCompraDTOResponse",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cantidad", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombreProducto", type = String.class)
                }
        )
})

@Data
@Entity
@Table(name = "Ordenes")
public class OrdenesCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private int id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "id_datos_fk")
    private int id_datos_fk;

    @ManyToOne
    @JoinColumn(name = "id_datos_fk", insertable = false, updatable = false)
    private DatosProducto datosProducto;


    public OrdenesCompra(int cantidad) {
        this.cantidad = cantidad;
    }

    public OrdenesCompra() {
    }
}
