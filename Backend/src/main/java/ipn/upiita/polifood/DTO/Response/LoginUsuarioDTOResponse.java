package ipn.upiita.polifood.DTO.Response;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUsuarioDTOResponse implements Serializable {
    private String correoInstitucional;
    private String contrasenia;

    public LoginUsuarioDTOResponse(String correoInstitucional, String contrasenia) {
        this.correoInstitucional = correoInstitucional;
        this.contrasenia = contrasenia;
    }
}
