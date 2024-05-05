package Entidades;

import Entidades.Compras;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(CuentasPagar.class)
public class CuentasPagar_ { 

    public static volatile SingularAttribute<CuentasPagar, Date> vencCuota;
    public static volatile SingularAttribute<CuentasPagar, String> estado;
    public static volatile SingularAttribute<CuentasPagar, Integer> cuota;
    public static volatile SingularAttribute<CuentasPagar, Compras> idCompra;
    public static volatile SingularAttribute<CuentasPagar, Integer> idCuentaPagar;
    public static volatile SingularAttribute<CuentasPagar, BigInteger> saldo;
    public static volatile SingularAttribute<CuentasPagar, BigInteger> importe;

}