package Entidades;

import Entidades.NotasDebitosDet;
import Entidades.Timbrados;
import Entidades.UsuariosSucursales;
import Entidades.Ventas;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasDebitos.class)
public class NotasDebitos_ { 

    public static volatile SingularAttribute<NotasDebitos, String> nroComprobante;
    public static volatile SingularAttribute<NotasDebitos, String> estado;
    public static volatile SingularAttribute<NotasDebitos, Integer> idNotaDebito;
    public static volatile SingularAttribute<NotasDebitos, Date> fechaVencimiento;
    public static volatile ListAttribute<NotasDebitos, NotasDebitosDet> notasDebitosDetList;
    public static volatile SingularAttribute<NotasDebitos, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<NotasDebitos, Timbrados> idTimbrado;
    public static volatile SingularAttribute<NotasDebitos, Date> fechaEmision;
    public static volatile SingularAttribute<NotasDebitos, BigInteger> nroTimbrado;
    public static volatile SingularAttribute<NotasDebitos, Ventas> idVenta;

}