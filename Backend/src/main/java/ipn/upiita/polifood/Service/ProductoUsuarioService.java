package ipn.upiita.polifood.Service;
import ipn.upiita.polifood.DTO.ProductoUsuarioDTORequest;
import ipn.upiita.polifood.repository.ProductoUsuarioRepository;
import ipn.upiita.polifood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Service
public class ProductoUsuarioService {
    @Autowired
    ProductoUsuarioRepository productoUsuarioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PersistenceContext
    EntityManager em;

    public Object insertarProductoUsuario(ProductoUsuarioDTORequest productoUsuarioDTORequest){

        StoredProcedureQuery spq=em.createNamedStoredProcedureQuery("insertarProductoUsuario");
        spq.setParameter("p_correo",productoUsuarioDTORequest.getProductoUsuarioDTO().getCorreoInstitucional());
        spq.execute();
        return spq.getResultList();
    }
    public Object borrarProductoJoindatos(int id, String correo){

        StoredProcedureQuery spq=em.createNamedStoredProcedureQuery("borrarProductoJoindatos");
        spq.setParameter("p_idProducto",id);
        spq.setParameter("p_correoInsititucional",correo);

        spq.execute();
        return spq.getSingleResult();
    }

}

