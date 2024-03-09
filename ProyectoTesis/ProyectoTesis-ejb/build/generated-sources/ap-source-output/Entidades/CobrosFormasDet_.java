package Entidades;

import Entidades.Cobros;
import Entidades.CobrosFormasDetPK;
import Entidades.TransaccionesComerciales;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(CobrosFormasDet.class)
public class CobrosFormasDet_ { 

    public static volatile SingularAttribute<CobrosFormasDet, BigDecimal> montoDet;
    public static volatile SingularAttribute<CobrosFormasDet, TransaccionesComerciales> transaccionesComerciales;
    public static volatile SingularAttribute<CobrosFormasDet, CobrosFormasDetPK> cobrosFormasDetPK;
    public static volatile SingularAttribute<CobrosFormasDet, Cobros> cobros;

}