package Entidades;

import Entidades.Productos;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Descuentos.class)
public class Descuentos_ { 

    public static volatile SingularAttribute<Descuentos, String> descripcion;
    public static volatile SingularAttribute<Descuentos, BigInteger> porcDesc;
    public static volatile SingularAttribute<Descuentos, Integer> idDescuento;
    public static volatile SingularAttribute<Descuentos, Date> fechaInicio;
    public static volatile ListAttribute<Descuentos, Productos> productosList;
    public static volatile SingularAttribute<Descuentos, Date> fechaFin;

}