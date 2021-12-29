package ipn.upiita.polifood.Controller;

import ipn.upiita.polifood.DTO.Response.LoginUsuarioDTOResponse;
import ipn.upiita.polifood.Service.UsuarioService;
import ipn.upiita.polifood.commons.GenericResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/login")
public class LoginController extends CommonController{
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(path = "/loginUser/{correo}/{password}",method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDTO<?>> login(@PathVariable("correo") String correo, @PathVariable("password") String password){
        LoginUsuarioDTOResponse loginUsuarioDTOResponse = (LoginUsuarioDTOResponse) usuarioService.obtenerUsuariobyCorreoContrasenia(correo,password);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El usuario y contraseña son correctos",
                loginUsuarioDTOResponse));
    }

}
