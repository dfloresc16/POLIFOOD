package ipn.upiita.polifood.Controller;

import ipn.upiita.polifood.DTO.DatosPersonalesDTORequest;
import ipn.upiita.polifood.DTO.DatosPersonalesDTOResponse;
import ipn.upiita.polifood.Entities.DatosPersonales;
import ipn.upiita.polifood.Service.DatosPersonalesService;
import ipn.upiita.polifood.commons.GenericResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Datos")
public class DatosPersonalesController extends CommonController  {

    @Autowired
    DatosPersonalesService datosPersonalesservice;

    @RequestMapping(value = "/nuevosDatospersonales",method = RequestMethod.POST)
    public ResponseEntity<GenericResponseDTO<?>> insertar(@RequestBody DatosPersonalesDTORequest datosPersonalesDTORequest){
        DatosPersonalesDTOResponse datosPersonales1 = (DatosPersonalesDTOResponse) datosPersonalesservice.insertarDatosPersonales(datosPersonalesDTORequest);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El registro fue agregado",
                datosPersonales1));
    }



    @RequestMapping(value = "/listarDatosPersonales", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDTO<?>> obtener(){
        List<DatosPersonales> datosPersonales1 = datosPersonalesservice.obtenerDatosPersonales();
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. Usuario Encontrado",datosPersonales1));
    }




}
