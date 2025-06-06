package Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import Entities.EstadoOrdenCompra;

@Entity
@Table(name = "orden_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado")
    private EstadoOrdenCompra estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proveedor")
    private Proveedor proveedor;
    
    @OneToMany(mappedBy = "orden_compra")
    private List<OrdenCompraDetalle> ordenCompraDetalleList;
    
}
