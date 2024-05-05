package Entidades;

import Entidades.Vehiculos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Modelos.class)
public class Modelos_ { 

    public static volatile SingularAttribute<Modelos, String> descripcion;
    public static volatile SingularAttribute<Modelos, Integer> idModelo;
    public static volatile ListAttribute<Modelos, Vehiculos> vehiculosList;

}