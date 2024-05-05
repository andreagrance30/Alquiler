package Entidades;

import Entidades.Compras;
import Entidades.ComprasDetPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(ComprasDet.class)
public class ComprasDet_ { 

    public static volatile SingularAttribute<ComprasDet, Compras> compras;
    public static volatile SingularAttribute<ComprasDet, ComprasDetPK> comprasDetPK;
    public static volatile SingularAttribute<ComprasDet, BigInteger> cantidad;
    public static volatile SingularAttribute<ComprasDet, BigInteger> porcIva;
    public static volatile SingularAttribute<ComprasDet, Stock> stock;
    public static volatile SingularAttribute<ComprasDet, BigInteger> precioUni;

}