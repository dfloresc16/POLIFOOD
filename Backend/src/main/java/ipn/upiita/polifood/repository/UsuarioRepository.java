package ipn.upiita.polifood.repository;

import ipn.upiita.polifood.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findById(int id);

    @Procedure(name = "borrarUsuario")
    void deleteUsuario(String p_correo);

    @Procedure(name = "buscarUsuario")
    Usuario findByCorreo(String p_correo);


}
