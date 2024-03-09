package Entidades;

import Entidades.Cobros;
import Entidades.EntidadesEmisoras;
import Entidades.TiposCheques;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(CobrosCheques.class)
public class CobrosCheques_ { 

    public static volatile SingularAttribute<CobrosCheques, String> estado;
    public static volatile SingularAttribute<CobrosCheques, TiposCheques> idTipoCheque;
    public static volatile SingularAttribute<CobrosCheques, String> nroCheque;
    public static volatile SingularAttribute<CobrosCheques, Integer> idCobroCheque;
    public static volatile SingularAttribute<CobrosCheques, EntidadesEmisoras> idEntidadEmisora;
    public static volatile SingularAttribute<CobrosCheques, Date> fechaEmision;
    public static volatile SingularAttribute<CobrosCheques, Date> fechaRetiro;
    public static volatile SingularAttribute<CobrosCheques, Cobros> idCobro;

}