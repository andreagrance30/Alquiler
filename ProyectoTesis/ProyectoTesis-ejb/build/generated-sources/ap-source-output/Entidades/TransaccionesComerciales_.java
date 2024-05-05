package Entidades;

import Entidades.ArqueosCajasDet;
import Entidades.CobrosFormasDet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(TransaccionesComerciales.class)
public class TransaccionesComerciales_ { 

    public static volatile SingularAttribute<TransaccionesComerciales, String> descripcion;
    public static volatile ListAttribute<TransaccionesComerciales, CobrosFormasDet> cobrosFormasDetList;
    public static volatile ListAttribute<TransaccionesComerciales, ArqueosCajasDet> arqueosCajasDetList;
    public static volatile SingularAttribute<TransaccionesComerciales, Integer> idTransaccionComercial;

}