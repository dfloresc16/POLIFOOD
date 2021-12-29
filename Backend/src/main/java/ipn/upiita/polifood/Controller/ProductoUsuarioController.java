package ipn.upiita.polifood.Controller;


import ipn.upiita.polifood.DTO.ProductoJoinDatosDTOResponse;
import ipn.upiita.polifood.DTO.ProductoUsuarioDTORequest;
import ipn.upiita.polifood.DTO.ProductoUsuarioDTOResponse;
import ipn.upiita.polifood.Service.ProductoUsuarioService;
import ipn.upiita.polifood.commons.GenericResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Productousuario")
public class ProductoUsuarioController extends CommonController {
    @Autowired
    ProductoUsuarioService productoUsuarioService;

    @RequestMapping(value = "/nuevo")
    public ResponseEntity<GenericResponseDTO<?>> insertarproductousuario(@RequestBody ProductoUsuarioDTORequest productoUsuarioDTORequest) {
        List<ProductoUsuarioDTOResponse> productoUsuarioDTOResponse = (List<ProductoUsuarioDTOResponse>) productoUsuarioService.insertarProductoUsuario(productoUsuarioDTORequest);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El registro fue agregado",
                productoUsuarioDTOResponse));
    }

    @RequestMapping(value = "/borrar/{id}/{correo}", method = RequestMethod.DELETE)
    public ResponseEntity<GenericResponseDTO<?>> eliminar(@PathVariable("id") Integer id, @PathVariable("correo") String correo) {
        ProductoJoinDatosDTOResponse productoJoindatosDTOResponse = (ProductoJoinDatosDTOResponse) productoUsuarioService.borrarProductoJoindatos(id, correo);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El registro fue agregado",
                productoJoindatosDTOResponse));
    }
}