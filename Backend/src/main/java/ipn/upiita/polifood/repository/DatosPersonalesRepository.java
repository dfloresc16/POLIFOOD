package ipn.upiita.polifood.repository;

import ipn.upiita.polifood.Entities.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales,Integer> {

}
