package org.example;

import Servicios.EquipoService;
import models.Equipo;
import repositories.EquipoRepository;

public class Main2 {
    static void main() {
        EquipoRepository repo=new EquipoRepository(
                SessionFactoryProvider.getSessionFactory()
        );
        EquipoService service=new EquipoService(
                SessionFactoryProvider.getSessionFactory(),
                repo
        );
        service.añadirNewEquipo("Equipo1Prubea","Categoria");
    }
}
