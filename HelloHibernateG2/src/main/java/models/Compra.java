package models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "responsable", nullable = false)
    private String responsable;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;


}