package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoUsuarioDTO implements Serializable {
    public int idPorducto;
    public int idUsuariofk;
    private String correoInstitucional;

}
