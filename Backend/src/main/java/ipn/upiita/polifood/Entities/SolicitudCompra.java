package ipn.upiita.polifood.Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Solicitud")
public class SolicitudCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private int id;


    @ManyToOne
    @JoinColumn(name = "id_compra_fk", insertable = false,updatable = false)
    private OrdenesCompra ordenesCompra;

    @ManyToOne
    @JoinColumn(name = "id_compra_fk", insertable = false,updatable = false)
    private ProductoUsuario productoUsuario;


}
