package ipn.upiita.polifood.Service;

import ipn.upiita.polifood.DTO.Request.OrdenesCompraDTORequest;
import ipn.upiita.polifood.Entities.OrdenesCompra;
import ipn.upiita.polifood.repository.OrdenesCompraRepository;
import ipn.upiita.polifood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class OrdenesCompraService {
    @Autowired
    OrdenesCompraRepository ordenesCompraRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PersistenceContext
    EntityManager em;

    public Object insertarOrdenCompra(OrdenesCompraDTORequest ordenesCompraDTORequest){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("insertarCompra");
        spq.setParameter("p_nombreProducto", ordenesCompraDTORequest.getOrdenesCompraDTO().getNombreProducto());
        spq.setParameter("p_cantidad", ordenesCompraDTORequest.getOrdenesCompraDTO().getCantidad());
        spq.execute();
        return spq.getSingleResult();
    }
    public List<OrdenesCompra> obtenerOrdenes(){
        return ordenesCompraRepository.findAll();
    }
}
