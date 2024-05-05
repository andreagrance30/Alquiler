package Entidades;

import Entidades.Clientes;
import Entidades.PresupuestosClientes;
import Entidades.SolicitudesPedidosDet;
import Entidades.UsuariosSucursales;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(SolicitudesPedidos.class)
public class SolicitudesPedidos_ { 

    public static volatile SingularAttribute<SolicitudesPedidos, String> estado;
    public static volatile SingularAttribute<SolicitudesPedidos, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<SolicitudesPedidos, Date> fechaPedido;
    public static volatile SingularAttribute<SolicitudesPedidos, Integer> idSolicitudPedido;
    public static volatile SingularAttribute<SolicitudesPedidos, String> direccionDevolucion;
    public static volatile SingularAttribute<SolicitudesPedidos, BigInteger> presupuestoCliente;
    public static volatile ListAttribute<SolicitudesPedidos, SolicitudesPedidosDet> solicitudesPedidosDetList;
    public static volatile SingularAttribute<SolicitudesPedidos, String> direccionEntrega;
    public static volatile SingularAttribute<SolicitudesPedidos, Date> fechaDevolucion;
    public static volatile SingularAttribute<SolicitudesPedidos, Clientes> idCliente;
    public static volatile SingularAttribute<SolicitudesPedidos, Date> fechaEntrega;
    public static volatile SingularAttribute<SolicitudesPedidos, String> observacion;
    public static volatile ListAttribute<SolicitudesPedidos, PresupuestosClientes> presupuestosClientesList;

}