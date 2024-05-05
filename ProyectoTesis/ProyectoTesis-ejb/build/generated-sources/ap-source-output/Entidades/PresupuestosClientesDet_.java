package Entidades;

import Entidades.PresupuestosClientes;
import Entidades.PresupuestosClientesDetPK;
import Entidades.Productos;
import Entidades.Stock;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(PresupuestosClientesDet.class)
public class PresupuestosClientesDet_ { 

    public static volatile SingularAttribute<PresupuestosClientesDet, BigInteger> cantidad;
    public static volatile SingularAttribute<PresupuestosClientesDet, BigInteger> porcIva;
    public static volatile SingularAttribute<PresupuestosClientesDet, PresupuestosClientes> presupuestosClientes;
    public static volatile SingularAttribute<PresupuestosClientesDet, Stock> stock;
    public static volatile SingularAttribute<PresupuestosClientesDet, BigInteger> precioUni;
    public static volatile SingularAttribute<PresupuestosClientesDet, Productos> productos;
    public static volatile SingularAttribute<PresupuestosClientesDet, PresupuestosClientesDetPK> presupuestosClientesDetPK;

}