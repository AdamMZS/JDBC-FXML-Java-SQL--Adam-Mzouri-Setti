package Model;

import lombok.Data;

@Data
public class Equipo {

    private String id;
    private String nombre;
    private String categoria;
    private String disponible;
    public Equipo(){

    }
    public Equipo(String id,String nombre,String categoria,String disponible) {
        this.id=id;
        this.nombre=nombre;
        this.categoria=categoria;
        this.disponible=disponible;
    }
}