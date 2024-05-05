package Entidades;

import Entidades.AperturaCierreCaja;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(RecaudacionesDepositar.class)
public class RecaudacionesDepositar_ { 

    public static volatile SingularAttribute<RecaudacionesDepositar, Date> fecha;
    public static volatile SingularAttribute<RecaudacionesDepositar, String> estado;
    public static volatile SingularAttribute<RecaudacionesDepositar, AperturaCierreCaja> idAperturaCierreCaja;
    public static volatile SingularAttribute<RecaudacionesDepositar, BigDecimal> totalCheque;
    public static volatile SingularAttribute<RecaudacionesDepositar, BigDecimal> totalEfectivo;
    public static volatile SingularAttribute<RecaudacionesDepositar, Integer> idRecaudacionDepositar;

}