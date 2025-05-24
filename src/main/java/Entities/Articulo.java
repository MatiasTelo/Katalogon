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

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "stock_seguridad")
    private Integer stockSeguridad;
    
    @Column(name = "demanda")
    private Integer demanda;
    
    @Column(name = "costo_mantenimiento")
    private float costoMantenimiento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proveedor_predeterminado_id")
    private Proveedor proveedorPredeterminado;
    
    @ManyToMany
    @JoinTable(
        name = "lista_proveedores",
        joinColumns = @JoinColumn(name = "articulo_id"),
        inverseJoinColumns = @JoinColumn(name = "proveedor_id")
    )
    private List<Proveedor> proveedores;

    
    
}
