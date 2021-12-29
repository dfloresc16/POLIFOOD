package ipn.upiita.polifood.repository;

import ipn.upiita.polifood.Entities.ProductoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoUsuarioRepository extends JpaRepository<ProductoUsuario,Integer> {

    /*@Procedure(name = "insertarProductoUsuario")
    ProductoUsuario insertProductoUsuarios(LocalDateTime p_subida);

    @Procedure(name = "borrarProductoUsuario")
    void deleteProductoUsuario(int p_idProducto);

    @Procedure(name = "buscarProductoUsuario")
    ProductoUsuario findById(int p_idProducto);*/
}
