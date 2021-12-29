package ipn.upiita.polifood.DTO.Response;

import lombok.Data;

import java.io.Serializable;
@Data
public class RegistroUsuarioDTOResponse implements Serializable {
    private String correoInstitucional;
    private String telefonoCelular;
    private String contrasenia;
    private String noBoleta;
    private String nombre;
    private String paterno;
    private String materno;

    public RegistroUsuarioDTOResponse(String correoInstitucional, String telefonoCelular, String contrasenia, String noBoleta, String nombre, String paterno, String materno) {
        this.correoInstitucional = correoInstitucional;
        this.telefonoCelular = telefonoCelular;
        this.contrasenia = contrasenia;
        this.noBoleta = noBoleta;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
    }
}
