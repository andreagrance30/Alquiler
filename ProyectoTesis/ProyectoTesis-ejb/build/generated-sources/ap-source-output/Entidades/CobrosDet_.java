package Entidades;

import Entidades.Cobros;
import Entidades.CobrosDetPK;
import Entidades.CuentasCobrar;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(CobrosDet.class)
public class CobrosDet_ { 

    public static volatile SingularAttribute<CobrosDet, Cobros> cobros;
    public static volatile SingularAttribute<CobrosDet, CuentasCobrar> cuentasCobrar;
    public static volatile SingularAttribute<CobrosDet, CobrosDetPK> cobrosDetPK;
    public static volatile SingularAttribute<CobrosDet, BigDecimal> montoCobro;

}