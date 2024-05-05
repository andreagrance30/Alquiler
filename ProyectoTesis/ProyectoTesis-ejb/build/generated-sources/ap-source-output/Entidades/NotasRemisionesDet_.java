package Entidades;

import Entidades.NotasRemisiones;
import Entidades.NotasRemisionesDetPK;
import Entidades.Stock;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(NotasRemisionesDet.class)
public class NotasRemisionesDet_ { 

    public static volatile SingularAttribute<NotasRemisionesDet, NotasRemisionesDetPK> notasRemisionesDetPK;
    public static volatile SingularAttribute<NotasRemisionesDet, BigDecimal> cantidad;
    public static volatile SingularAttribute<NotasRemisionesDet, Stock> stock;
    public static volatile SingularAttribute<NotasRemisionesDet, NotasRemisiones> notasRemisiones;

}