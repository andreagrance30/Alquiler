package Entidades;

import Entidades.Compras;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(CuentasPagar.class)
public class CuentasPagar_ { 

    public static volatile SingularAttribute<CuentasPagar, Date> vencCuota;
    public static volatile SingularAttribute<CuentasPagar, String> estado;
    public static volatile SingularAttribute<CuentasPagar, Integer> cuota;
    public static volatile SingularAttribute<CuentasPagar, Compras> idCompra;
    public static volatile SingularAttribute<CuentasPagar, Integer> idCuentaPagar;
    public static volatile SingularAttribute<CuentasPagar, BigDecimal> saldo;
    public static volatile SingularAttribute<CuentasPagar, BigDecimal> importe;

}