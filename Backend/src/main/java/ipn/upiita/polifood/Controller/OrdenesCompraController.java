package ipn.upiita.polifood.Controller;

import ipn.upiita.polifood.DTO.Request.OrdenesCompraDTORequest;
import ipn.upiita.polifood.DTO.Response.OrdenesCompraDTORespose;
import ipn.upiita.polifood.Entities.OrdenesCompra;
import ipn.upiita.polifood.Service.OrdenesCompraService;
import ipn.upiita.polifood.commons.GenericResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/OrdenCompra")
public class OrdenesCompraController extends CommonController {
    @Autowired
    OrdenesCompraService ordenesCompraService;

    @RequestMapping(path = "/nuevo", method = RequestMethod.POST)
    public ResponseEntity<GenericResponseDTO<?>> insertar(@RequestBody OrdenesCompraDTORequest ordenesCompraDTORequest){
        OrdenesCompraDTORespose ordenesCompraDTOResponse = (OrdenesCompraDTORespose) ordenesCompraService.insertarOrdenCompra(ordenesCompraDTORequest);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El registro fue agregado",ordenesCompraDTOResponse));
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDTO<?>> obtener(){
        List<OrdenesCompra> ordenesCompras = ordenesCompraService.obtenerOrdenes();
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. Usuario Encontrado",ordenesCompras));
    }
}
