package Entidades;

import Entidades.IntinerariosDet;
import Entidades.OrdenesTrabajosDet;
import Entidades.UsuariosSucursales;
import Entidades.Ventas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(OrdenesTrabajos.class)
public class OrdenesTrabajos_ { 

    public static volatile SingularAttribute<OrdenesTrabajos, Integer> idOrdenTrabajo;
    public static volatile SingularAttribute<OrdenesTrabajos, String> estado;
    public static volatile ListAttribute<OrdenesTrabajos, OrdenesTrabajosDet> ordenesTrabajosDetList;
    public static volatile ListAttribute<OrdenesTrabajos, IntinerariosDet> intinerariosDetList;
    public static volatile SingularAttribute<OrdenesTrabajos, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<OrdenesTrabajos, Date> fechaOrden;
    public static volatile SingularAttribute<OrdenesTrabajos, Ventas> idVenta;

}