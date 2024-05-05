package Entidades;

import Entidades.Clientes;
import Entidades.Condiciones;
import Entidades.CuentasCobrar;
import Entidades.NotasCreditos;
import Entidades.NotasDebitos;
import Entidades.NotasRemisiones;
import Entidades.OrdenesTrabajos;
import Entidades.PresupuestosClientes;
import Entidades.Timbrados;
import Entidades.UsuariosSucursales;
import Entidades.VentasDet;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, String> nroComprobante;
    public static volatile SingularAttribute<Ventas, Condiciones> idCondicion;
    public static volatile SingularAttribute<Ventas, String> estado;
    public static volatile ListAttribute<Ventas, CuentasCobrar> cuentasCobrarList;
    public static volatile SingularAttribute<Ventas, Date> fechaVencimiento;
    public static volatile SingularAttribute<Ventas, UsuariosSucursales> usuariosSucursales;
    public static volatile ListAttribute<Ventas, NotasCreditos> notasCreditosList;
    public static volatile SingularAttribute<Ventas, Date> fechaEmision;
    public static volatile SingularAttribute<Ventas, PresupuestosClientes> idPresupuestoCliente;
    public static volatile ListAttribute<Ventas, VentasDet> ventasDetList;
    public static volatile SingularAttribute<Ventas, Integer> idVenta;
    public static volatile ListAttribute<Ventas, OrdenesTrabajos> ordenesTrabajosList;
    public static volatile SingularAttribute<Ventas, Clientes> idCliente;
    public static volatile ListAttribute<Ventas, NotasDebitos> notasDebitosList;
    public static volatile ListAttribute<Ventas, NotasRemisiones> notasRemisionesList;
    public static volatile SingularAttribute<Ventas, Timbrados> idTimbrado;
    public static volatile SingularAttribute<Ventas, BigInteger> nroTimbrado;

}