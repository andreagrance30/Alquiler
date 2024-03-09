package Entidades;

import Entidades.NotasRemisiones;
import Entidades.NotasRemisionesDetPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasRemisionesDet.class)
public class NotasRemisionesDet_ { 

    public static volatile SingularAttribute<NotasRemisionesDet, NotasRemisionesDetPK> notasRemisionesDetPK;
    public static volatile SingularAttribute<NotasRemisionesDet, BigInteger> cantidad;
    public static volatile SingularAttribute<NotasRemisionesDet, Stock> stock;
    public static volatile SingularAttribute<NotasRemisionesDet, NotasRemisiones> notasRemisiones;

}