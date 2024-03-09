package Entidades;

import Entidades.Empleados;
import Entidades.OrdenesTrabajos;
import Entidades.OrdenesTrabajosDetPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(OrdenesTrabajosDet.class)
public class OrdenesTrabajosDet_ { 

    public static volatile SingularAttribute<OrdenesTrabajosDet, String> estado;
    public static volatile SingularAttribute<OrdenesTrabajosDet, Empleados> empleados;
    public static volatile SingularAttribute<OrdenesTrabajosDet, OrdenesTrabajos> ordenesTrabajos;
    public static volatile SingularAttribute<OrdenesTrabajosDet, OrdenesTrabajosDetPK> ordenesTrabajosDetPK;

}