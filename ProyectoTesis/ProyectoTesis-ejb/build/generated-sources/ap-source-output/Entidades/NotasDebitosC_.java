package Entidades;

import Entidades.Compras;
import Entidades.NotasDebitosDetC;
import Entidades.UsuariosSucursales;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
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
    public static volatile SingularAttribute<NotasDebitosC, BigDecimal> nroTimbrado;

}