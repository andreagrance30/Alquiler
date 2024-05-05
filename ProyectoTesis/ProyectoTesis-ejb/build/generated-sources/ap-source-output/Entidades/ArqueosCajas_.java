package Entidades;

import Entidades.AperturaCierreCaja;
import Entidades.ArqueosCajasDet;
import Entidades.TiposArqueos;
import Entidades.UsuariosSucursales;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(ArqueosCajas.class)
public class ArqueosCajas_ { 

    public static volatile SingularAttribute<ArqueosCajas, Date> fecha;
    public static volatile SingularAttribute<ArqueosCajas, AperturaCierreCaja> idAperturaCierreCaja;
    public static volatile SingularAttribute<ArqueosCajas, TiposArqueos> idTipoArqueo;
    public static volatile SingularAttribute<ArqueosCajas, UsuariosSucursales> usuariosSucursales;
    public static volatile ListAttribute<ArqueosCajas, ArqueosCajasDet> arqueosCajasDetList;
    public static volatile SingularAttribute<ArqueosCajas, Integer> idArqueoCaja;

}