package Entidades;

import Entidades.Compras;
import Entidades.Personas;
import Entidades.Presupuestos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile ListAttribute<Proveedores, Presupuestos> presupuestosList;
    public static volatile SingularAttribute<Proveedores, String> estado;
    public static volatile ListAttribute<Proveedores, Compras> comprasList;
    public static volatile SingularAttribute<Proveedores, Integer> idProveedor;
    public static volatile SingularAttribute<Proveedores, Personas> personas;

}