package Entidades;

import Entidades.NotasRemisionesC;
import Entidades.NotasRemisionesDetCPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasRemisionesDetC.class)
public class NotasRemisionesDetC_ { 

    public static volatile SingularAttribute<NotasRemisionesDetC, NotasRemisionesDetCPK> notasRemisionesDetCPK;
    public static volatile SingularAttribute<NotasRemisionesDetC, NotasRemisionesC> notasRemisionesC;
    public static volatile SingularAttribute<NotasRemisionesDetC, BigInteger> cantidad;
    public static volatile SingularAttribute<NotasRemisionesDetC, Stock> stock;

}