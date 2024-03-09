package Entidades;

import Entidades.Compras;
import Entidades.Presupuestos;
import Entidades.Ventas;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Condiciones.class)
public class Condiciones_ { 

    public static volatile SingularAttribute<Condiciones, Integer> idCondicion;
    public static volatile SingularAttribute<Condiciones, String> descripcion;
    public static volatile ListAttribute<Condiciones, Presupuestos> presupuestosList;
    public static volatile SingularAttribute<Condiciones, BigDecimal> intervaloDias;
    public static volatile ListAttribute<Condiciones, Compras> comprasList;
    public static volatile ListAttribute<Condiciones, Ventas> ventasList;
    public static volatile SingularAttribute<Condiciones, BigDecimal> cantidadCuotas;

}