package Entidades;

import Entidades.Timbrados;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(TiposComprobantes.class)
public class TiposComprobantes_ { 

    public static volatile SingularAttribute<TiposComprobantes, String> descripcion;
    public static volatile SingularAttribute<TiposComprobantes, Integer> idTipoComprobante;
    public static volatile ListAttribute<TiposComprobantes, Timbrados> timbradosList;

}