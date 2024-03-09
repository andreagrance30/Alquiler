package Entidades;

import Entidades.NotasCreditosDet;
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
@StaticMetamodel(NotasCreditos.class)
public class NotasCreditos_ { 

    public static volatile SingularAttribute<NotasCreditos, String> nroComprobante;
    public static volatile ListAttribute<NotasCreditos, NotasCreditosDet> notasCreditosDetList;
    public static volatile SingularAttribute<NotasCreditos, String> estado;
    public static volatile SingularAttribute<NotasCreditos, Date> fechaVencimiento;
    public static volatile SingularAttribute<NotasCreditos, Integer> idNotaCredito;
    public static volatile SingularAttribute<NotasCreditos, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<NotasCreditos, Timbrados> idTimbrado;
    public static volatile SingularAttribute<NotasCreditos, Date> fechaEmision;
    public static volatile SingularAttribute<NotasCreditos, BigInteger> nroTimbrado;
    public static volatile SingularAttribute<NotasCreditos, Ventas> idVenta;

}