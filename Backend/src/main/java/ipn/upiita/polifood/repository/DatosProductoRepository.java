package ipn.upiita.polifood.repository;

import ipn.upiita.polifood.Entities.DatosProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosProductoRepository extends JpaRepository<DatosProducto,Integer> {
}

