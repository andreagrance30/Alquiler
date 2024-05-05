package Entidades;

import Entidades.Empleados;
import Entidades.OrdenesCompras;
import Entidades.PedidosDet;
import Entidades.Presupuestos;
import Entidades.UsuariosSucursales;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile ListAttribute<Pedidos, OrdenesCompras> ordenesComprasList;
    public static volatile ListAttribute<Pedidos, Presupuestos> presupuestosList;
    public static volatile SingularAttribute<Pedidos, String> estado;
    public static volatile ListAttribute<Pedidos, PedidosDet> pedidosDetList;
    public static volatile SingularAttribute<Pedidos, Empleados> idEmpleado;
    public static volatile SingularAttribute<Pedidos, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<Pedidos, Date> fechaPedido;
    public static volatile SingularAttribute<Pedidos, Integer> idPedido;

}