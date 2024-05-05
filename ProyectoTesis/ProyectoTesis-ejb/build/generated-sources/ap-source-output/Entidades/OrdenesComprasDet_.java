package Entidades;

import Entidades.OrdenesCompras;
import Entidades.OrdenesComprasDetPK;
import Entidades.Presupuestos;
import Entidades.PresupuestosDet;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(OrdenesComprasDet.class)
public class OrdenesComprasDet_ { 

    public static volatile SingularAttribute<OrdenesComprasDet, OrdenesCompras> ordenesCompras;
    public static volatile SingularAttribute<OrdenesComprasDet, Presupuestos> idPresupuesto;
    public static volatile SingularAttribute<OrdenesComprasDet, PresupuestosDet> presupuestosDet;
    public static volatile SingularAttribute<OrdenesComprasDet, BigInteger> cantidad;
    public static volatile SingularAttribute<OrdenesComprasDet, OrdenesComprasDetPK> ordenesComprasDetPK;
    public static volatile SingularAttribute<OrdenesComprasDet, BigInteger> porcIva;
    public static volatile SingularAttribute<OrdenesComprasDet, Stock> stock;
    public static volatile SingularAttribute<OrdenesComprasDet, BigInteger> precioUni;

}