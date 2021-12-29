package ipn.upiita.polifood.DTO.Request;

import ipn.upiita.polifood.DTO.UsuarioDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUsuarioDTORequest implements Serializable {
    private UsuarioDTO usuarioDTO;
}
