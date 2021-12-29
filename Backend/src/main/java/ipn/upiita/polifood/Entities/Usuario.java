package ipn.upiita.polifood.Entities;

import ipn.upiita.polifood.DTO.Response.LoginUsuarioDTOResponse;
import ipn.upiita.polifood.DTO.UsuarioDTOResponse;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "UsuarioDTOResponse", classes = {
                @ConstructorResult(targetClass = UsuarioDTOResponse.class, columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "correo"),
                        @ColumnResult(name = "boleta"),
                        @ColumnResult(name = "celular"),
                        @ColumnResult(name = "contrasenia")
                })
        }
        ),
        @SqlResultSetMapping(
                name = "LoginUsuarioDTOResponse", classes = {
                @ConstructorResult(targetClass = LoginUsuarioDTOResponse.class, columns = {
                        @ColumnResult(name = "correo"),
                        @ColumnResult(name = "contrasenia")
                })
        }
        )
})



@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "buscarUsuario",
                procedureName = "sp_buscarUsuario", resultSetMappings = "UsuarioDTOResponse",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "loginUsuario",
                procedureName = "sp_loginUsuario", resultSetMappings = "LoginUsuarioDTOResponse",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN,name = "p_correoInstitucional",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_contrasenia", type = String.class)
                }
        )
})

@Data
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "correo")
    private String correoInstitucional;

    @Column(name = "boleta")
    private String noBoleta;

    @Column(name = "celular")
    private String telefonoCelular;

    @Column(name = "contrasenia")
    private String contrasenia;

    @OneToMany
    @JoinColumn(name = "id")
    private Set<OrdenesCompra> ordenesCompra;


    public Usuario() {
    }

    public Usuario(String correoInstitucional, String noBoleta, String telefonoCelular, String contrasenia) {
        this.correoInstitucional = correoInstitucional;
        this.noBoleta = noBoleta;
        this.telefonoCelular = telefonoCelular;
        this.contrasenia = contrasenia;
    }
}
