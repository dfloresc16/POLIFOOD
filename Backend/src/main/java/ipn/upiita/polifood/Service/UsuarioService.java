package ipn.upiita.polifood.Service;

import ipn.upiita.polifood.DTO.Request.LoginUsuarioDTORequest;
import ipn.upiita.polifood.DTO.UsuarioDTORequest;
import ipn.upiita.polifood.Entities.Usuario;
import ipn.upiita.polifood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


@Service
    public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PersistenceContext
    EntityManager em;

    public Usuario insertarUsuario(UsuarioDTORequest usuarioDTORequest){
        Usuario usuario = new Usuario();
        usuario.setCorreoInstitucional(usuarioDTORequest.getUsuarioDTO().getCorreoInstitucional());
        usuario.setContrasenia(usuarioDTORequest.getUsuarioDTO().getContrasenia());
        usuario.setTelefonoCelular(usuarioDTORequest.getUsuarioDTO().getTelefonoCelular());
        usuario.setNoBoleta(usuarioDTORequest.getUsuarioDTO().getNoBoleta());
        return usuarioRepository.save(usuario);
    }

    public void borrarUsuario(String p_correo){
        usuarioRepository.deleteUsuario(p_correo);
    }

    public void borrarUsuarioId(int id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuariobyId(int id){
        return usuarioRepository.findById(id);
    }

    public Object obtenerUsuariobyCorreo(String p_correo){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("buscarUsuario");
        spq.setParameter("p_correo", p_correo);
        spq.execute();
        return spq.getSingleResult();
    }

    public Object obtenerUsuariobyCorreoContrasenia(String correo,String contrasenia){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("loginUsuario");
        spq.setParameter("p_correoInstitucional", correo);
        spq.setParameter("p_contrasenia", contrasenia);
        spq.execute();
        return spq.getSingleResult();
    }
}
