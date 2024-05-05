package Entidades;

import Entidades.ArqueosCajas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(TiposArqueos.class)
public class TiposArqueos_ { 

    public static volatile SingularAttribute<TiposArqueos, String> descripcion;
    public static volatile SingularAttribute<TiposArqueos, Integer> idTipoArqueo;
    public static volatile ListAttribute<TiposArqueos, ArqueosCajas> arqueosCajasList;

}