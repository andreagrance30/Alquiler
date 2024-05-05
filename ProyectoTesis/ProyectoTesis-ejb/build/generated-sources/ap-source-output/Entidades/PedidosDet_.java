package Entidades;

import Entidades.Pedidos;
import Entidades.PedidosDetPK;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(PedidosDet.class)
public class PedidosDet_ { 

    public static volatile SingularAttribute<PedidosDet, PedidosDetPK> pedidosDetPK;
    public static volatile SingularAttribute<PedidosDet, BigInteger> cantidad;
    public static volatile SingularAttribute<PedidosDet, Pedidos> pedidos;
    public static volatile SingularAttribute<PedidosDet, Stock> stock;

}