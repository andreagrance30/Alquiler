package Entidades;

import Entidades.Productos;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Descuentos.class)
public class Descuentos_ { 

    public static volatile SingularAttribute<Descuentos, String> descripcion;
    public static volatile SingularAttribute<Descuentos, BigDecimal> porcDesc;
    public static volatile SingularAttribute<Descuentos, Integer> idDescuento;
    public static volatile SingularAttribute<Descuentos, Date> fechaInicio;
    public static volatile ListAttribute<Descuentos, Productos> productosList;
    public static volatile SingularAttribute<Descuentos, Date> fechaFin;

}