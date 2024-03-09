package Entidades;

import Entidades.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Clasificaciones.class)
public class Clasificaciones_ { 

    public static volatile SingularAttribute<Clasificaciones, String> descripcion;
    public static volatile SingularAttribute<Clasificaciones, Integer> idClasificacion;
    public static volatile ListAttribute<Clasificaciones, Productos> productosList;

}