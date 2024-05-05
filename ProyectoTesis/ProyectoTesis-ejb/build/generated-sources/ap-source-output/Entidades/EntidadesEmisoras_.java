package Entidades;

import Entidades.CobrosCheques;
import Entidades.Tarjetas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(EntidadesEmisoras.class)
public class EntidadesEmisoras_ { 

    public static volatile SingularAttribute<EntidadesEmisoras, String> descripcion;
    public static volatile ListAttribute<EntidadesEmisoras, CobrosCheques> cobrosChequesList;
    public static volatile SingularAttribute<EntidadesEmisoras, String> estado;
    public static volatile SingularAttribute<EntidadesEmisoras, Integer> idEntidadEmisora;
    public static volatile SingularAttribute<EntidadesEmisoras, String> direccion;
    public static volatile SingularAttribute<EntidadesEmisoras, String> telefono;
    public static volatile ListAttribute<EntidadesEmisoras, Tarjetas> tarjetasList;
    public static volatile SingularAttribute<EntidadesEmisoras, String> email;

}