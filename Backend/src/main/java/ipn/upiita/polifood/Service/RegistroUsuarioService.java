package ipn.upiita.polifood.Service;

import ipn.upiita.polifood.DTO.Request.RegistroUsuarioDTORequest;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Service
public class RegistroUsuarioService {
    @PersistenceContext
    EntityManager em;
    public Object insertarUsuarioDatos(RegistroUsuarioDTORequest registroUsuarioDTORequest){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("insertarUsuarioDatos");
        spq.setParameter("p_correoInstitucional",registroUsuarioDTORequest.getUsuarioDTO().getCorreoInstitucional());
        spq.setParameter("p_telefonoCelular",registroUsuarioDTORequest.getUsuarioDTO().getTelefonoCelular());
        spq.setParameter("p_noBoleta",registroUsuarioDTORequest.getUsuarioDTO().getNoBoleta());
        spq.setParameter("p_contrasenia",registroUsuarioDTORequest.getUsuarioDTO().getContrasenia());
        spq.setParameter("p_nombre",registroUsuarioDTORequest.getDatosPersonalesDTO().getNombre());
        spq.setParameter("p_aPaterno",registroUsuarioDTORequest.getDatosPersonalesDTO().getPaterno());
        spq.setParameter("p_aMaterno",registroUsuarioDTORequest.getDatosPersonalesDTO().getMaterno());
        spq.execute();
        return spq.getSingleResult();
    }
}
