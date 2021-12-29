package ipn.upiita.polifood.DTO.Request;

import ipn.upiita.polifood.DTO.DatosPersonalesDTO;
import ipn.upiita.polifood.DTO.UsuarioDTO;
import lombok.Data;


@Data
public class RegistroUsuarioDTORequest {
    private UsuarioDTO usuarioDTO;
    private DatosPersonalesDTO datosPersonalesDTO;
}
