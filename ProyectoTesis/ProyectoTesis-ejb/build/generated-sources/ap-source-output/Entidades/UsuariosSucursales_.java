package Entidades;

import Entidades.AjustesInventarios;
import Entidades.AperturaCierreCaja;
import Entidades.ArqueosCajas;
import Entidades.Compras;
import Entidades.Intinerarios;
import Entidades.NotasCreditos;
import Entidades.NotasCreditosC;
import Entidades.NotasDebitos;
import Entidades.NotasDebitosC;
import Entidades.NotasRemisiones;
import Entidades.NotasRemisionesC;
import Entidades.OrdenesCompras;
import Entidades.OrdenesTrabajos;
import Entidades.Pedidos;
import Entidades.Presupuestos;
import Entidades.PresupuestosClientes;
import Entidades.SolicitudesPedidos;
import Entidades.Sucursales;
import Entidades.Usuarios;
import Entidades.UsuariosSucursalesPK;
import Entidades.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(UsuariosSucursales.class)
public class UsuariosSucursales_ { 

    public static volatile ListAttribute<UsuariosSucursales, OrdenesCompras> ordenesComprasList;
    public static volatile SingularAttribute<UsuariosSucursales, String> estado;
    public static volatile ListAttribute<UsuariosSucursales, NotasDebitosC> notasDebitosCList;
    public static volatile ListAttribute<UsuariosSucursales, NotasRemisionesC> notasRemisionesCList;
    public static volatile SingularAttribute<UsuariosSucursales, UsuariosSucursalesPK> usuariosSucursalesPK;
    public static volatile ListAttribute<UsuariosSucursales, Compras> comprasList;
    public static volatile ListAttribute<UsuariosSucursales, ArqueosCajas> arqueosCajasList;
    public static volatile ListAttribute<UsuariosSucursales, NotasCreditos> notasCreditosList;
    public static volatile ListAttribute<UsuariosSucursales, Ventas> ventasList;
    public static volatile SingularAttribute<UsuariosSucursales, Usuarios> usuarios;
    public static volatile ListAttribute<UsuariosSucursales, Presupuestos> presupuestosList;
    public static volatile ListAttribute<UsuariosSucursales, OrdenesTrabajos> ordenesTrabajosList;
    public static volatile SingularAttribute<UsuariosSucursales, Sucursales> sucursales;
    public static volatile ListAttribute<UsuariosSucursales, NotasDebitos> notasDebitosList;
    public static volatile ListAttribute<UsuariosSucursales, NotasRemisiones> notasRemisionesList;
    public static volatile ListAttribute<UsuariosSucursales, AjustesInventarios> ajustesInventariosList;
    public static volatile ListAttribute<UsuariosSucursales, Intinerarios> intinerariosList;
    public static volatile ListAttribute<UsuariosSucursales, SolicitudesPedidos> solicitudesPedidosList;
    public static volatile ListAttribute<UsuariosSucursales, NotasCreditosC> notasCreditosCList;
    public static volatile ListAttribute<UsuariosSucursales, Pedidos> pedidosList;
    public static volatile ListAttribute<UsuariosSucursales, AperturaCierreCaja> aperturaCierreCajaList;
    public static volatile ListAttribute<UsuariosSucursales, PresupuestosClientes> presupuestosClientesList;

}