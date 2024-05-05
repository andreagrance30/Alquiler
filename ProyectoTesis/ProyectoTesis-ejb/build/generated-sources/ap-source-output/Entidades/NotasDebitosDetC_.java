package Entidades;

import Entidades.NotasDebitosC;
import Entidades.NotasDebitosDetCPK;
import Entidades.Stock;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(NotasDebitosDetC.class)
public class NotasDebitosDetC_ { 

    public static volatile SingularAttribute<NotasDebitosDetC, NotasDebitosDetCPK> notasDebitosDetCPK;
    public static volatile SingularAttribute<NotasDebitosDetC, BigDecimal> cantidad;
    public static volatile SingularAttribute<NotasDebitosDetC, BigDecimal> porcIva;
    public static volatile SingularAttribute<NotasDebitosDetC, NotasDebitosC> notasDebitosC;
    public static volatile SingularAttribute<NotasDebitosDetC, Stock> stock;
    public static volatile SingularAttribute<NotasDebitosDetC, BigDecimal> precioUni;

}