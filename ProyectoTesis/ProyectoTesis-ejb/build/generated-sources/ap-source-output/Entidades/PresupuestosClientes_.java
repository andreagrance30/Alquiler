package Entidades;

import Entidades.PresupuestosClientesDet;
import Entidades.SolicitudesPedidos;
import Entidades.UsuariosSucursales;
import Entidades.Ventas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(PresupuestosClientes.class)
public class PresupuestosClientes_ { 

    public static volatile SingularAttribute<PresupuestosClientes, String> estado;
    public static volatile ListAttribute<PresupuestosClientes, PresupuestosClientesDet> presupuestosClientesDetList;
    public static volatile SingularAttribute<PresupuestosClientes, UsuariosSucursales> usuariosSucursales;
    public static volatile ListAttribute<PresupuestosClientes, Ventas> ventasList;
    public static volatile SingularAttribute<PresupuestosClientes, Integer> idPresupuestoCliente;
    public static volatile SingularAttribute<PresupuestosClientes, SolicitudesPedidos> idSolicitudPedido;
    public static volatile SingularAttribute<PresupuestosClientes, Date> fechaPresupuesto;

}