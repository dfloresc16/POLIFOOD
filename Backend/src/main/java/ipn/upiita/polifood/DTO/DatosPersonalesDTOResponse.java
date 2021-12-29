package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class DatosPersonalesDTOResponse implements Serializable {
    private String nombre;

    private String paterno;

    private String materno;

    private int id_usuario_fk;

    public DatosPersonalesDTOResponse(String nombre, String paterno, String materno, int id_usuario_fk){
        this.nombre=nombre;
        this.paterno=paterno;
        this.materno=materno;
        this.id_usuario_fk=id_usuario_fk;
    }
}
