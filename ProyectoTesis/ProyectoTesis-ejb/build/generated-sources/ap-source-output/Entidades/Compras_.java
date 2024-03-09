package Entidades;

import Entidades.ComprasDet;
import Entidades.Condiciones;
import Entidades.CuentasPagar;
import Entidades.NotasCreditosC;
import Entidades.NotasDebitosC;
import Entidades.NotasRemisionesC;
import Entidades.OrdenesCompras;
import Entidades.Proveedores;
import Entidades.UsuariosSucursales;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, String> nroComprobante;
    public static volatile SingularAttribute<Compras, Condiciones> idCondicion;
    public static volatile SingularAttribute<Compras, OrdenesCompras> idOrdenCompra;
    public static volatile SingularAttribute<Compras, String> estado;
    public static volatile ListAttribute<Compras, NotasDebitosC> notasDebitosCList;
    public static volatile ListAttribute<Compras, NotasRemisionesC> notasRemisionesCList;
    public static volatile SingularAttribute<Compras, Date> fechaVencimiento;
    public static volatile SingularAttribute<Compras, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<Compras, Date> fechaEmision;
    public static volatile ListAttribute<Compras, ComprasDet> comprasDetList;
    public static volatile SingularAttribute<Compras, Date> fechaComprobante;
    public static volatile ListAttribute<Compras, CuentasPagar> cuentasPagarList;
    public static volatile SingularAttribute<Compras, Integer> idCompra;
    public static volatile SingularAttribute<Compras, Proveedores> idProveedor;
    public static volatile ListAttribute<Compras, NotasCreditosC> notasCreditosCList;
    public static volatile SingularAttribute<Compras, BigDecimal> nroTimbrado;

}