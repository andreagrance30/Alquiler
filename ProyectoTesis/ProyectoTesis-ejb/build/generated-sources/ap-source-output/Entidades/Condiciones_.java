package Entidades;

import Entidades.Compras;
import Entidades.Presupuestos;
import Entidades.Ventas;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Condiciones.class)
public class Condiciones_ { 

    public static volatile SingularAttribute<Condiciones, Integer> idCondicion;
    public static volatile SingularAttribute<Condiciones, String> descripcion;
    public static volatile ListAttribute<Condiciones, Presupuestos> presupuestosList;
    public static volatile SingularAttribute<Condiciones, BigInteger> intervaloDias;
    public static volatile ListAttribute<Condiciones, Compras> comprasList;
    public static volatile ListAttribute<Condiciones, Ventas> ventasList;
    public static volatile SingularAttribute<Condiciones, BigInteger> cantidadCuotas;

}