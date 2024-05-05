package Entidades;

import Entidades.Cobros;
import Entidades.CobrosDetPK;
import Entidades.CuentasCobrar;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(CobrosDet.class)
public class CobrosDet_ { 

    public static volatile SingularAttribute<CobrosDet, Cobros> cobros;
    public static volatile SingularAttribute<CobrosDet, CuentasCobrar> cuentasCobrar;
    public static volatile SingularAttribute<CobrosDet, CobrosDetPK> cobrosDetPK;
    public static volatile SingularAttribute<CobrosDet, BigInteger> montoCobro;

}