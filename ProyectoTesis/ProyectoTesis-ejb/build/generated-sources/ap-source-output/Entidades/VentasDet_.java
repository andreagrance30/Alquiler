package Entidades;

import Entidades.Stock;
import Entidades.Ventas;
import Entidades.VentasDetPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(VentasDet.class)
public class VentasDet_ { 

    public static volatile SingularAttribute<VentasDet, Ventas> ventas;
    public static volatile SingularAttribute<VentasDet, BigDecimal> cantidad;
    public static volatile SingularAttribute<VentasDet, VentasDetPK> ventasDetPK;
    public static volatile SingularAttribute<VentasDet, BigDecimal> porcIva;
    public static volatile SingularAttribute<VentasDet, Stock> stock;
    public static volatile SingularAttribute<VentasDet, BigDecimal> precioUni;

}