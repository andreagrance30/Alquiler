package Entidades;

import Entidades.AjustesInventarios;
import Entidades.ComprasDet;
import Entidades.Depositos;
import Entidades.NotasCreditosDet;
import Entidades.NotasCreditosDetC;
import Entidades.NotasDebitosDet;
import Entidades.NotasDebitosDetC;
import Entidades.NotasRemisionesDet;
import Entidades.NotasRemisionesDetC;
import Entidades.OrdenesComprasDet;
import Entidades.PedidosDet;
import Entidades.PresupuestosDet;
import Entidades.Productos;
import Entidades.StockPK;
import Entidades.VentasDet;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile ListAttribute<Stock, NotasDebitosDetC> notasDebitosDetCList;
    public static volatile ListAttribute<Stock, PresupuestosDet> presupuestosDetList;
    public static volatile ListAttribute<Stock, ComprasDet> comprasDetList;
    public static volatile ListAttribute<Stock, OrdenesComprasDet> ordenesComprasDetList;
    public static volatile ListAttribute<Stock, VentasDet> ventasDetList;
    public static volatile ListAttribute<Stock, NotasCreditosDet> notasCreditosDetList;
    public static volatile ListAttribute<Stock, NotasCreditosDetC> notasCreditosDetCList;
    public static volatile SingularAttribute<Stock, BigDecimal> existencia;
    public static volatile ListAttribute<Stock, NotasRemisionesDet> notasRemisionesDetList;
    public static volatile ListAttribute<Stock, PedidosDet> pedidosDetList;
    public static volatile ListAttribute<Stock, NotasDebitosDet> notasDebitosDetList;
    public static volatile ListAttribute<Stock, AjustesInventarios> ajustesInventariosList;
    public static volatile SingularAttribute<Stock, StockPK> stockPK;
    public static volatile SingularAttribute<Stock, Depositos> depositos;
    public static volatile ListAttribute<Stock, NotasRemisionesDetC> notasRemisionesDetCList;
    public static volatile SingularAttribute<Stock, Productos> productos;

}