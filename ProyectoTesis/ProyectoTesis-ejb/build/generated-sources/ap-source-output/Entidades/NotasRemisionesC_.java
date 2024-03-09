package Entidades;

import Entidades.Compras;
import Entidades.NotasRemisionesDetC;
import Entidades.UsuariosSucursales;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasRemisionesC.class)
public class NotasRemisionesC_ { 

    public static volatile SingularAttribute<NotasRemisionesC, String> nroComprobante;
    public static volatile SingularAttribute<NotasRemisionesC, String> estado;
    public static volatile SingularAttribute<NotasRemisionesC, String> motivo;
    public static volatile SingularAttribute<NotasRemisionesC, Date> fechaVencimiento;
    public static volatile SingularAttribute<NotasRemisionesC, String> direccionLlegada;
    public static volatile SingularAttribute<NotasRemisionesC, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<NotasRemisionesC, Date> fechaEmision;
    public static volatile SingularAttribute<NotasRemisionesC, Date> fechaComprobante;
    public static volatile SingularAttribute<NotasRemisionesC, Date> fechaFin;
    public static volatile SingularAttribute<NotasRemisionesC, Date> fechaInicio;
    public static volatile SingularAttribute<NotasRemisionesC, String> direccionPartida;
    public static volatile SingularAttribute<NotasRemisionesC, Compras> idCompra;
    public static volatile ListAttribute<NotasRemisionesC, NotasRemisionesDetC> notasRemisionesDetCList;
    public static volatile SingularAttribute<NotasRemisionesC, Integer> idNotaRemsionC;
    public static volatile SingularAttribute<NotasRemisionesC, BigInteger> nroTimbrado;

}