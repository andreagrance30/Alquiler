package Entidades;

import Entidades.CobrosDet;
import Entidades.Ventas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(CuentasCobrar.class)
public class CuentasCobrar_ { 

    public static volatile SingularAttribute<CuentasCobrar, Date> vencCuota;
    public static volatile SingularAttribute<CuentasCobrar, String> estado;
    public static volatile SingularAttribute<CuentasCobrar, Integer> cuota;
    public static volatile SingularAttribute<CuentasCobrar, BigDecimal> saldo;
    public static volatile SingularAttribute<CuentasCobrar, BigDecimal> importe;
    public static volatile SingularAttribute<CuentasCobrar, Integer> idCuentaCobrar;
    public static volatile SingularAttribute<CuentasCobrar, BigDecimal> interes;
    public static volatile SingularAttribute<CuentasCobrar, Ventas> idVenta;
    public static volatile ListAttribute<CuentasCobrar, CobrosDet> cobrosDetList;

}