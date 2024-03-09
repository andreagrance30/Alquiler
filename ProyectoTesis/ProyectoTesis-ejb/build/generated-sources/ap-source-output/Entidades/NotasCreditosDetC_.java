package Entidades;

import Entidades.NotasCreditosC;
import Entidades.NotasCreditosDetCPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasCreditosDetC.class)
public class NotasCreditosDetC_ { 

    public static volatile SingularAttribute<NotasCreditosDetC, NotasCreditosDetCPK> notasCreditosDetCPK;
    public static volatile SingularAttribute<NotasCreditosDetC, NotasCreditosC> notasCreditosC;
    public static volatile SingularAttribute<NotasCreditosDetC, BigInteger> cantidad;
    public static volatile SingularAttribute<NotasCreditosDetC, BigInteger> porcIva;
    public static volatile SingularAttribute<NotasCreditosDetC, Stock> stock;
    public static volatile SingularAttribute<NotasCreditosDetC, BigInteger> precioUni;

}