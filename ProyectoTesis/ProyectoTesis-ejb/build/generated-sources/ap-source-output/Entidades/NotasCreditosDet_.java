package Entidades;

import Entidades.NotasCreditos;
import Entidades.NotasCreditosDetPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasCreditosDet.class)
public class NotasCreditosDet_ { 

    public static volatile SingularAttribute<NotasCreditosDet, NotasCreditosDetPK> notasCreditosDetPK;
    public static volatile SingularAttribute<NotasCreditosDet, NotasCreditos> notasCreditos;
    public static volatile SingularAttribute<NotasCreditosDet, BigInteger> cantidad;
    public static volatile SingularAttribute<NotasCreditosDet, BigInteger> porcIva;
    public static volatile SingularAttribute<NotasCreditosDet, Stock> stock;
    public static volatile SingularAttribute<NotasCreditosDet, BigInteger> precioUni;

}