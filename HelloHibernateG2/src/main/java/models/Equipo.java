package models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "equipo", schema = "ad")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//POSTRE SECUENCE ---- SQL IDENTIDY
    private Long id;

    @Column(name = "nombre",length = 50,nullable = false,unique = true)
    private String nombre;

    private String categoria;

    private Boolean disponible;



}