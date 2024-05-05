package Entidades;

import Entidades.DepartamentosCiudadesBarrios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Barrios.class)
public class Barrios_ { 

    public static volatile SingularAttribute<Barrios, String> descripcion;
    public static volatile SingularAttribute<Barrios, Integer> idBarrio;
    public static volatile ListAttribute<Barrios, DepartamentosCiudadesBarrios> departamentosCiudadesBarriosList;

}