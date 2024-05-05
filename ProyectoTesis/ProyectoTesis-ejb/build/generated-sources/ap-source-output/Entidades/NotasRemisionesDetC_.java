package Entidades;

import Entidades.NotasRemisionesC;
import Entidades.NotasRemisionesDetCPK;
import Entidades.Stock;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(NotasRemisionesDetC.class)
public class NotasRemisionesDetC_ { 

    public static volatile SingularAttribute<NotasRemisionesDetC, NotasRemisionesDetCPK> notasRemisionesDetCPK;
    public static volatile SingularAttribute<NotasRemisionesDetC, NotasRemisionesC> notasRemisionesC;
    public static volatile SingularAttribute<NotasRemisionesDetC, BigDecimal> cantidad;
    public static volatile SingularAttribute<NotasRemisionesDetC, Stock> stock;

}