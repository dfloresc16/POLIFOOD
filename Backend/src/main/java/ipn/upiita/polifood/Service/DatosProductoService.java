package ipn.upiita.polifood.Service;

import ipn.upiita.polifood.DTO.DatosProductoDTORequest;
import ipn.upiita.polifood.DTO.Request.ProductosPropiosDTORequest;
import ipn.upiita.polifood.Entities.DatosProducto;
import ipn.upiita.polifood.repository.DatosProductoRepository;
import ipn.upiita.polifood.repository.ProductoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class DatosProductoService {
    @Autowired
    DatosProductoRepository datosProductoRepository;

    @PersistenceContext
    EntityManager em;

    public Object insertarDatosProducto(DatosProductoDTORequest datosProductoDTORequest){
        StoredProcedureQuery spq=em.createNamedStoredProcedureQuery("insertarDatosProducto");
        spq.setParameter("p_nombreProducto",datosProductoDTORequest.getDatosProductoDTO().getNombreProducto());
        spq.setParameter("p_precio",datosProductoDTORequest.getDatosProductoDTO().getPrecio());
        spq.setParameter("p_descripcion",datosProductoDTORequest.getDatosProductoDTO().getDescripcion());
        spq.setParameter("p_correoInstitucional",datosProductoDTORequest.getDatosProductoDTO().getCorreoInstitucional());
        spq.execute();
        return spq.getSingleResult();
    }

    public Object listarProductosPropios(String correo,String contrasenia){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("listarProductosPropios");
        spq.setParameter("p_correoInstitucional", correo);
        spq.setParameter("p_contrasenia", contrasenia);
        spq.execute();
        return spq.getResultList();
    }
    public Object listarProductos(){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("listarProductos");
        spq.execute();
        return spq.getResultList();
    }

}
