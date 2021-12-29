package ipn.upiita.polifood.Service;


import ipn.upiita.polifood.DTO.DatosPersonalesDTORequest;
import ipn.upiita.polifood.Entities.DatosPersonales;
import ipn.upiita.polifood.repository.DatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class DatosPersonalesService {
    @Autowired
    DatosPersonalesRepository datosPersonalesRepository;

    @PersistenceContext
    EntityManager em;

    public Object insertarDatosPersonales(DatosPersonalesDTORequest datosPersonalesDTORequest){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("insertarDatosPersonales");
        spq.setParameter("p_nombre",datosPersonalesDTORequest.getDatosPersonalesDTO().getNombre());
        spq.setParameter("p_aPaterno",datosPersonalesDTORequest.getDatosPersonalesDTO().getPaterno());
        spq.setParameter("p_aMaterno",datosPersonalesDTORequest.getDatosPersonalesDTO().getMaterno());
        spq.execute();
        return spq.getSingleResult();
    }

    public DatosPersonales saveDatosPersonales(DatosPersonales datosPersonales){
        return datosPersonalesRepository.save(datosPersonales);
    }

    public List<DatosPersonales> obtenerDatosPersonales(){
        return datosPersonalesRepository.findAll();
    }





}
