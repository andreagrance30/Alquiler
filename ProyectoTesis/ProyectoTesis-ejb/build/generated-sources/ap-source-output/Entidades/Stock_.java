package Entidades;

import Entidades.Depositos;
import Entidades.PresupuestosClientesDet;
import Entidades.Productos;
import Entidades.SolicitudesPedidosDet;
import Entidades.StockPK;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, BigInteger> existencia;
    public static volatile ListAttribute<Stock, SolicitudesPedidosDet> solicitudesPedidosDetList;
    public static volatile ListAttribute<Stock, PresupuestosClientesDet> presupuestosClientesDetList;
    public static volatile SingularAttribute<Stock, StockPK> stockPK;
    public static volatile SingularAttribute<Stock, Depositos> depositos;
    public static volatile SingularAttribute<Stock, Productos> productos;

}