package Entidades;

import Entidades.Compras;
import Entidades.NotasDebitosDetC;
import Entidades.UsuariosSucursales;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasDebitosC.class)
public class NotasDebitosC_ { 

    public static volatile SingularAttribute<NotasDebitosC, String> nroComprobante;
    public static volatile ListAttribute<NotasDebitosC, NotasDebitosDetC> notasDebitosDetCList;
    public static volatile SingularAttribute<NotasDebitosC, String> estado;
    public static volatile SingularAttribute<NotasDebitosC, Integer> idNotaDebitoC;
    public static volatile SingularAttribute<NotasDebitosC, Date> fechaVencimiento;
    public static volatile SingularAttribute<NotasDebitosC, Compras> idCompra;
    public static volatile SingularAttribute<NotasDebitosC, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<NotasDebitosC, Date> fechaEmision;
    public static volatile SingularAttribute<NotasDebitosC, Date> fechaComprobante;
    public static volatile SingularAttribute<NotasDebitosC, BigInteger> nroTimbrado;

}