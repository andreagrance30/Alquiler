package Entidades;

import Entidades.Compras;
import Entidades.NotasCreditosDetC;
import Entidades.UsuariosSucursales;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasCreditosC.class)
public class NotasCreditosC_ { 

    public static volatile SingularAttribute<NotasCreditosC, Integer> idNotaCreditoC;
    public static volatile SingularAttribute<NotasCreditosC, String> nroComprobante;
    public static volatile ListAttribute<NotasCreditosC, NotasCreditosDetC> notasCreditosDetCList;
    public static volatile SingularAttribute<NotasCreditosC, String> estado;
    public static volatile SingularAttribute<NotasCreditosC, Date> fechaVencimiento;
    public static volatile SingularAttribute<NotasCreditosC, Compras> idCompra;
    public static volatile SingularAttribute<NotasCreditosC, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<NotasCreditosC, Date> fechaEmision;
    public static volatile SingularAttribute<NotasCreditosC, Date> fechaComprobante;
    public static volatile SingularAttribute<NotasCreditosC, BigInteger> nroTimbrado;

}