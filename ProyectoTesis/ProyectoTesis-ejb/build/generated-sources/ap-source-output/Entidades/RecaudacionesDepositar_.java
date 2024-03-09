package Entidades;

import Entidades.AperturaCierreCaja;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(RecaudacionesDepositar.class)
public class RecaudacionesDepositar_ { 

    public static volatile SingularAttribute<RecaudacionesDepositar, Date> fecha;
    public static volatile SingularAttribute<RecaudacionesDepositar, String> estado;
    public static volatile SingularAttribute<RecaudacionesDepositar, AperturaCierreCaja> idAperturaCierreCaja;
    public static volatile SingularAttribute<RecaudacionesDepositar, BigInteger> totalCheque;
    public static volatile SingularAttribute<RecaudacionesDepositar, BigInteger> totalEfectivo;
    public static volatile SingularAttribute<RecaudacionesDepositar, Integer> idRecaudacionDepositar;

}