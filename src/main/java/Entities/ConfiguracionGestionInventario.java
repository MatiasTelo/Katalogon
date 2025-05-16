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

    @Column(name = "inventario_maximo")
    private Integer inventarioMaximo;

    @Column(name = "lote_optimo")
    private Integer loteOptimo;

    @Column(name = "punto_pedido")
    private Integer puntoPedido;

    @Column(name = "stock_seguridad")
    private Integer stockSeguridad;

    @ManyToOne
    @JoinColumn(name = "modelo_inventario_id")
    private ModeloInventario modeloInventario;
}