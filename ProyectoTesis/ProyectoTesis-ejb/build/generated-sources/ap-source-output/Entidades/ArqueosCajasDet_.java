package Entidades;

import Entidades.ArqueosCajas;
import Entidades.ArqueosCajasDetPK;
import Entidades.TransaccionesComerciales;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(ArqueosCajasDet.class)
public class ArqueosCajasDet_ { 

    public static volatile SingularAttribute<ArqueosCajasDet, BigDecimal> montoFisico;
    public static volatile SingularAttribute<ArqueosCajasDet, ArqueosCajas> arqueosCajas;
    public static volatile SingularAttribute<ArqueosCajasDet, TransaccionesComerciales> transaccionesComerciales;
    public static volatile SingularAttribute<ArqueosCajasDet, ArqueosCajasDetPK> arqueosCajasDetPK;
    public static volatile SingularAttribute<ArqueosCajasDet, BigDecimal> montoTeorico;

}