package ipn.upiita.polifood.Controller;

import ipn.upiita.polifood.DTO.DatosProductoDTORequest;
import ipn.upiita.polifood.DTO.DatosProductoDTOResponse;
import ipn.upiita.polifood.DTO.Request.ProductosPropiosDTORequest;
import ipn.upiita.polifood.Entities.DatosProducto;
import ipn.upiita.polifood.Service.DatosProductoService;
import ipn.upiita.polifood.commons.GenericResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/DatosProducto")
public class DatosProductoController extends CommonController {
    @Autowired
    DatosProductoService datosProductoService;

    @RequestMapping(value = "/insertarProducto", method = RequestMethod.POST)
    public ResponseEntity<GenericResponseDTO<?>> insertarProducto(@RequestBody DatosProductoDTORequest datosProductoDTORequest) {

        DatosProductoDTOResponse datosProducto = (DatosProductoDTOResponse) datosProductoService.insertarDatosProducto(datosProductoDTORequest);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El registro fue ingresado correctamente",
                datosProducto));
    }

    @RequestMapping(value = "/listarProductosPropios/{correo}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> listarProductos(@PathVariable("correo") String correo, @PathVariable("password") String password) {
        List<DatosProductoDTOResponse> datosProducto = (List<DatosProductoDTOResponse>) datosProductoService.listarProductosPropios(correo,password);
//        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
//                null, "Servicio ejecutado exitosamente. El registro fue encontrado",
//                datosProducto));
        return  ResponseEntity.ok(datosProductoService.listarProductosPropios(correo, password));
    }

    @DeleteMapping("/eliminado/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<?> obtener() {

//        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
//                null, "Servicio ejecutado exitosamente. Usuario Encontrado", datosProductos1));
        return  ResponseEntity.ok(datosProductoService.listarProductos());
    }


}
