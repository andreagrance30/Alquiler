package Entidades;

import Entidades.ArqueosCajas;
import Entidades.ArqueosCajasDetPK;
import Entidades.TransaccionesComerciales;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(ArqueosCajasDet.class)
public class ArqueosCajasDet_ { 

    public static volatile SingularAttribute<ArqueosCajasDet, BigInteger> montoFisico;
    public static volatile SingularAttribute<ArqueosCajasDet, ArqueosCajas> arqueosCajas;
    public static volatile SingularAttribute<ArqueosCajasDet, TransaccionesComerciales> transaccionesComerciales;
    public static volatile SingularAttribute<ArqueosCajasDet, ArqueosCajasDetPK> arqueosCajasDetPK;
    public static volatile SingularAttribute<ArqueosCajasDet, BigInteger> montoTeorico;

}