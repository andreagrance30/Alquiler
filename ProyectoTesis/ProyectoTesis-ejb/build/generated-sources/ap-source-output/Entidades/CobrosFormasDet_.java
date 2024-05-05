package Entidades;

import Entidades.Cobros;
import Entidades.CobrosFormasDetPK;
import Entidades.TransaccionesComerciales;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(CobrosFormasDet.class)
public class CobrosFormasDet_ { 

    public static volatile SingularAttribute<CobrosFormasDet, BigInteger> montoDet;
    public static volatile SingularAttribute<CobrosFormasDet, TransaccionesComerciales> transaccionesComerciales;
    public static volatile SingularAttribute<CobrosFormasDet, CobrosFormasDetPK> cobrosFormasDetPK;
    public static volatile SingularAttribute<CobrosFormasDet, Cobros> cobros;

}