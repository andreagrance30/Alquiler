package Entidades;

import Entidades.Empleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Cargos.class)
public class Cargos_ { 

    public static volatile SingularAttribute<Cargos, String> descripcion;
    public static volatile SingularAttribute<Cargos, Integer> idCargo;
    public static volatile ListAttribute<Cargos, Empleados> empleadosList;

}