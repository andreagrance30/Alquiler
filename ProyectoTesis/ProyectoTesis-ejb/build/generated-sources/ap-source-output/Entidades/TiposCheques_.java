package Entidades;

import Entidades.CobrosCheques;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(TiposCheques.class)
public class TiposCheques_ { 

    public static volatile SingularAttribute<TiposCheques, String> descripcion;
    public static volatile ListAttribute<TiposCheques, CobrosCheques> cobrosChequesList;
    public static volatile SingularAttribute<TiposCheques, Integer> idTipoCheque;

}