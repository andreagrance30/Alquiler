package Entidades;

import Entidades.Productos;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Impuestos.class)
public class Impuestos_ { 

    public static volatile SingularAttribute<Impuestos, String> descripcion;
    public static volatile ListAttribute<Impuestos, Productos> productosList;
    public static volatile SingularAttribute<Impuestos, Integer> idImpuesto;
    public static volatile SingularAttribute<Impuestos, BigInteger> porcIva;

}