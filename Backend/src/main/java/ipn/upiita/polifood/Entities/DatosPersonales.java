package ipn.upiita.polifood.Entities;

import ipn.upiita.polifood.DTO.DatosPersonalesDTOResponse;
import ipn.upiita.polifood.DTO.Response.RegistroUsuarioDTOResponse;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "DatosPersonalesDTOResponse", classes = {
                @ConstructorResult(targetClass = DatosPersonalesDTOResponse.class, columns = {
                        @ColumnResult(name = "nombre"),
                        @ColumnResult(name = "paterno"),
                        @ColumnResult(name = "materno"),
                        @ColumnResult(name = "id_usuario_fk")
                })
        }
        ),
        @SqlResultSetMapping(
                name = "RegistroUsuarioDTOResponse", classes = {
                @ConstructorResult(targetClass = RegistroUsuarioDTOResponse.class, columns = {
                        @ColumnResult(name = "correo"),
                        @ColumnResult(name = "celular"),
                        @ColumnResult(name = "contrasenia"),
                        @ColumnResult(name = "boleta"),
                        @ColumnResult(name = "nombre"),
                        @ColumnResult(name = "paterno"),
                        @ColumnResult(name = "materno"),
                })
        }
        )
})


@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "insertarDatosPersonales",
                procedureName = "sp_insertarDatosPersonales",resultSetMappings = "DatosPersonalesDTOResponse",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombre", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_aPaterno",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_aMaterno", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correoInstitucional", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "insertarUsuarioDatos",
                procedureName = "sp_insertarUsuarioDatos",resultSetMappings = "RegistroUsuarioDTOResponse",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correoInstitucional", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefonoCelular", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_noBoleta", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_contrasenia", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombre", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_aPaterno",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_aMaterno", type = String.class)
                }
        )
})

@Data
@Entity
@Table(name = "Personales")
public class DatosPersonales implements Serializable {
    @Id
    @Column(name="id_usuario_fk")
    private int id_usuario_fk;

    @OneToOne
    @JoinColumn(name = "id_usuario_fk", insertable = false,updatable = false)
    private Usuario usuario;

    @Column(name="nombre")
    private String nombre;

    @Column(name="paterno")
    private String paterno;

    @Column(name="materno")
    private String materno;


}
