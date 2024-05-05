package Entidades;

import Entidades.NotasDebitos;
import Entidades.NotasDebitosDetPK;
import Entidades.Stock;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(NotasDebitosDet.class)
public class NotasDebitosDet_ { 

    public static volatile SingularAttribute<NotasDebitosDet, NotasDebitos> notasDebitos;
    public static volatile SingularAttribute<NotasDebitosDet, BigDecimal> cantidad;
    public static volatile SingularAttribute<NotasDebitosDet, BigDecimal> porcIva;
    public static volatile SingularAttribute<NotasDebitosDet, Stock> stock;
    public static volatile SingularAttribute<NotasDebitosDet, NotasDebitosDetPK> notasDebitosDetPK;
    public static volatile SingularAttribute<NotasDebitosDet, BigDecimal> precioUni;

}