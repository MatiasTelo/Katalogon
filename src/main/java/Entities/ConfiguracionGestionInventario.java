package Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "configuracion_gestion_inventario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionGestionInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora_baja_configuracion")
    private LocalDateTime fechaHoraBajaConfiguracion;

    @Column(name = "fecha_hora_alta_configuracion")
    private LocalDateTime fechaHoraAltaConfiguracion;

    @Column(name = "lote_optimo")
    private Integer loteOptimo;

    @Column(name = "punto_pedido")
    private Integer puntoPedido;
    
    @Column(name = "tiempo_intervalo")
    private Integer tiempoIntervalo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "articulo_proveedor_id")
    private ArticuloProveedor articulo_proveedor;
}