package Entidades;

import Entidades.Compras;
import Entidades.ComprasDetPK;
import Entidades.Stock;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(ComprasDet.class)
public class ComprasDet_ { 

    public static volatile SingularAttribute<ComprasDet, Compras> compras;
    public static volatile SingularAttribute<ComprasDet, ComprasDetPK> comprasDetPK;
    public static volatile SingularAttribute<ComprasDet, BigDecimal> cantidad;
    public static volatile SingularAttribute<ComprasDet, BigDecimal> porcIva;
    public static volatile SingularAttribute<ComprasDet, Stock> stock;
    public static volatile SingularAttribute<ComprasDet, BigDecimal> precioUni;

}