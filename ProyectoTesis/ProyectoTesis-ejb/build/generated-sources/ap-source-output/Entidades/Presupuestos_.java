package Entidades;

import Entidades.Condiciones;
import Entidades.OrdenesComprasDet;
import Entidades.Pedidos;
import Entidades.PresupuestosDet;
import Entidades.Proveedores;
import Entidades.UsuariosSucursales;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Presupuestos.class)
public class Presupuestos_ { 

    public static volatile SingularAttribute<Presupuestos, Condiciones> idCondicion;
    public static volatile SingularAttribute<Presupuestos, String> estado;
    public static volatile ListAttribute<Presupuestos, PresupuestosDet> presupuestosDetList;
    public static volatile SingularAttribute<Presupuestos, Date> fechaCarga;
    public static volatile SingularAttribute<Presupuestos, Integer> idPresupuesto;
    public static volatile SingularAttribute<Presupuestos, Proveedores> idProveedor;
    public static volatile SingularAttribute<Presupuestos, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<Presupuestos, Pedidos> idPedido;
    public static volatile SingularAttribute<Presupuestos, Date> fechaPresupuesto;
    public static volatile ListAttribute<Presupuestos, OrdenesComprasDet> ordenesComprasDetList;
    public static volatile SingularAttribute<Presupuestos, Date> validezPresupuesto;
    public static volatile SingularAttribute<Presupuestos, BigDecimal> nroPresupuesto;

}