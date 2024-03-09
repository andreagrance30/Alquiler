package Entidades;

import Entidades.Presupuestos;
import Entidades.PresupuestosDetPK;
import Entidades.Stock;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(PresupuestosDet.class)
public class PresupuestosDet_ { 

    public static volatile SingularAttribute<PresupuestosDet, Presupuestos> presupuestos;
    public static volatile SingularAttribute<PresupuestosDet, PresupuestosDetPK> presupuestosDetPK;
    public static volatile SingularAttribute<PresupuestosDet, BigDecimal> cantidad;
    public static volatile SingularAttribute<PresupuestosDet, BigDecimal> porcIva;
    public static volatile SingularAttribute<PresupuestosDet, Stock> stock;
    public static volatile SingularAttribute<PresupuestosDet, BigDecimal> precioUni;

}