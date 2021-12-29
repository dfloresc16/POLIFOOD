package ipn.upiita.polifood.Controller;

import ipn.upiita.polifood.DTO.Request.RegistroUsuarioDTORequest;
import ipn.upiita.polifood.DTO.Response.RegistroUsuarioDTOResponse;
import ipn.upiita.polifood.Service.RegistroUsuarioService;
import ipn.upiita.polifood.commons.GenericResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/registro")
public class RegistroUsuarioController extends CommonController {
    @Autowired
    RegistroUsuarioService registroUsuarioService;

    @RequestMapping(value = "/newUser",method = RequestMethod.POST)
    public ResponseEntity<GenericResponseDTO<?>> insertar(@RequestBody RegistroUsuarioDTORequest registroUsuarioDTORequest){
        RegistroUsuarioDTOResponse registroUsuarioDTOResponse = (RegistroUsuarioDTOResponse) registroUsuarioService.insertarUsuarioDatos(registroUsuarioDTORequest);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El registro fue agregado",
                registroUsuarioDTOResponse));
    }
}
