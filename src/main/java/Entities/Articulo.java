package Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "articulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cod_articulo", nullable = false)
    private Integer codArticulo;

    @Column(name = "descripcion_articulo", nullable = false)
    private String descripcionArticulo;

    @Column(name = "fecha_hora_baja")
    private LocalDateTime fechaHoraBaja;

    @Column(name = "inventario_maximo")
    private Integer inventarioMaximo;

    @Column(name = "lote_optimo")
    private Integer loteOptimo;

    @Column(name = "punto_pedido")
    private Integer puntoPedido;

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "stock_seguridad")
    private Integer stockSeguridad;

    @ManyToOne
    @JoinColumn(name = "configuracion_id")
    private ConfiguracionGestionInventario configuracion;

    @OneToMany(mappedBy = "articulo")
    private List<VentaArticulo> ventas;

    @OneToMany(mappedBy = "articulo")
    private List<ArticuloProveedor> articuloProveedores;

    @OneToOne
    @JoinColumn(name = "proveedor_determinado_id")
    private Proveedor proveedorDeterminado;
}
