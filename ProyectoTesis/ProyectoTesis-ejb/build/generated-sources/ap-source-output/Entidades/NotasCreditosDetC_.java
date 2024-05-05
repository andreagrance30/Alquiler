package Entidades;

import Entidades.NotasCreditosC;
import Entidades.NotasCreditosDetCPK;
import Entidades.Stock;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(NotasCreditosDetC.class)
public class NotasCreditosDetC_ { 

    public static volatile SingularAttribute<NotasCreditosDetC, NotasCreditosDetCPK> notasCreditosDetCPK;
    public static volatile SingularAttribute<NotasCreditosDetC, NotasCreditosC> notasCreditosC;
    public static volatile SingularAttribute<NotasCreditosDetC, BigDecimal> cantidad;
    public static volatile SingularAttribute<NotasCreditosDetC, BigDecimal> porcIva;
    public static volatile SingularAttribute<NotasCreditosDetC, Stock> stock;
    public static volatile SingularAttribute<NotasCreditosDetC, BigDecimal> precioUni;

}