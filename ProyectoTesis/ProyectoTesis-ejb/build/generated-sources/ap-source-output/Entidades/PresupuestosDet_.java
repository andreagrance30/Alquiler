package Entidades;

import Entidades.OrdenesComprasDet;
import Entidades.Presupuestos;
import Entidades.PresupuestosDetPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(PresupuestosDet.class)
public class PresupuestosDet_ { 

    public static volatile SingularAttribute<PresupuestosDet, Presupuestos> presupuestos;
    public static volatile SingularAttribute<PresupuestosDet, PresupuestosDetPK> presupuestosDetPK;
    public static volatile SingularAttribute<PresupuestosDet, BigInteger> cantidad;
    public static volatile SingularAttribute<PresupuestosDet, BigInteger> porcIva;
    public static volatile SingularAttribute<PresupuestosDet, Stock> stock;
    public static volatile SingularAttribute<PresupuestosDet, BigInteger> precioUni;
    public static volatile ListAttribute<PresupuestosDet, OrdenesComprasDet> ordenesComprasDetList;

}