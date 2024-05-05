package Entidades;

import Entidades.CobrosDet;
import Entidades.Ventas;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(CuentasCobrar.class)
public class CuentasCobrar_ { 

    public static volatile SingularAttribute<CuentasCobrar, Date> vencCuota;
    public static volatile SingularAttribute<CuentasCobrar, String> estado;
    public static volatile SingularAttribute<CuentasCobrar, Integer> cuota;
    public static volatile SingularAttribute<CuentasCobrar, BigInteger> saldo;
    public static volatile SingularAttribute<CuentasCobrar, BigInteger> importe;
    public static volatile SingularAttribute<CuentasCobrar, Integer> idCuentaCobrar;
    public static volatile SingularAttribute<CuentasCobrar, BigInteger> interes;
    public static volatile SingularAttribute<CuentasCobrar, Ventas> idVenta;
    public static volatile ListAttribute<CuentasCobrar, CobrosDet> cobrosDetList;

}