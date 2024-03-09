package Entidades;

import Entidades.Clasificaciones;
import Entidades.Descuentos;
import Entidades.Impuestos;
import Entidades.PresupuestosClientesDet;
import Entidades.SolicitudesPedidosDet;
import Entidades.Stock;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, String> descripcion;
    public static volatile ListAttribute<Productos, Descuentos> descuentosList;
    public static volatile ListAttribute<Productos, SolicitudesPedidosDet> solicitudesPedidosDetList;
    public static volatile SingularAttribute<Productos, String> estado;
    public static volatile ListAttribute<Productos, Stock> stockList;
    public static volatile ListAttribute<Productos, PresupuestosClientesDet> presupuestosClientesDetList;
    public static volatile SingularAttribute<Productos, BigDecimal> precioCompra;
    public static volatile SingularAttribute<Productos, Clasificaciones> idClasificacion;
    public static volatile SingularAttribute<Productos, Integer> idProducto;
    public static volatile SingularAttribute<Productos, Impuestos> idImpuesto;
    public static volatile SingularAttribute<Productos, BigDecimal> precioVenta;

}