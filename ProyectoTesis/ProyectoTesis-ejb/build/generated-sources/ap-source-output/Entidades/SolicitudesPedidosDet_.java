package Entidades;

import Entidades.Productos;
import Entidades.SolicitudesPedidos;
import Entidades.SolicitudesPedidosDetPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(SolicitudesPedidosDet.class)
public class SolicitudesPedidosDet_ { 

    public static volatile SingularAttribute<SolicitudesPedidosDet, SolicitudesPedidos> solicitudesPedidos;
    public static volatile SingularAttribute<SolicitudesPedidosDet, BigInteger> cantidad;
    public static volatile SingularAttribute<SolicitudesPedidosDet, Stock> stock;
    public static volatile SingularAttribute<SolicitudesPedidosDet, SolicitudesPedidosDetPK> solicitudesPedidosDetPK;
    public static volatile SingularAttribute<SolicitudesPedidosDet, Productos> productos;

}