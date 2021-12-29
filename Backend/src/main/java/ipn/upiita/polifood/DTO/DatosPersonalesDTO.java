package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;

@Data

public class DatosPersonalesDTO implements Serializable {
    private String nombre;
    private String paterno;
    private String materno;

}
