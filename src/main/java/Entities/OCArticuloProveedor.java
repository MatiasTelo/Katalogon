package Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "oc_articulo_proveedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OCArticuloProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_proveedor_id")
    private ArticuloProveedor articuloProveedor;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ordencompra_id")
    private OrdenCompra orden_compra;
}
