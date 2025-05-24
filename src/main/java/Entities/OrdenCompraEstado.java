package Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orden_compra_estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenCompraEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    @Column(name = "fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @ManyToOne
    @JoinColumn(name = "estado_orden_compra_id")
    private EstadoOrdenCompra estadoOrdenCompra;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ordencompra_id")
    private OrdenCompra orden_compra;
}