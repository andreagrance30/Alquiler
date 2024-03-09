package Entidades;

import Entidades.NotasDebitos;
import Entidades.NotasDebitosDetPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasDebitosDet.class)
public class NotasDebitosDet_ { 

    public static volatile SingularAttribute<NotasDebitosDet, NotasDebitos> notasDebitos;
    public static volatile SingularAttribute<NotasDebitosDet, BigInteger> cantidad;
    public static volatile SingularAttribute<NotasDebitosDet, BigInteger> porcIva;
    public static volatile SingularAttribute<NotasDebitosDet, Stock> stock;
    public static volatile SingularAttribute<NotasDebitosDet, NotasDebitosDetPK> notasDebitosDetPK;
    public static volatile SingularAttribute<NotasDebitosDet, BigInteger> precioUni;

}