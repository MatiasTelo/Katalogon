package Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "articulo_proveedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "demora_entrega")
    private Integer demoraEntrega;

    @Column(name = "fecha_hora_baja")
    private LocalDateTime fechaHoraBaja;

    @Column(name = "precio_unitario")
    private Integer precioUnitario;
    
    @Column(name = "costo_pedido")
    private float costoPedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "modelo_id")
    private ModeloInventario modeloInventario;
    
    @OneToMany(mappedBy = "articulo_proveedor")
    private List<ConfiguracionGestionInventario> configuracion;
    
}
