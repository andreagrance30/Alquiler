package Entidades;

import Entidades.AperturaCierreCaja;
import Entidades.CobrosCheques;
import Entidades.CobrosDet;
import Entidades.CobrosFormasDet;
import Entidades.CobrosTarjetas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Cobros.class)
public class Cobros_ { 

    public static volatile ListAttribute<Cobros, CobrosCheques> cobrosChequesList;
    public static volatile SingularAttribute<Cobros, String> estado;
    public static volatile SingularAttribute<Cobros, AperturaCierreCaja> idAperturaCierreCaja;
    public static volatile ListAttribute<Cobros, CobrosFormasDet> cobrosFormasDetList;
    public static volatile ListAttribute<Cobros, CobrosTarjetas> cobrosTarjetasList;
    public static volatile SingularAttribute<Cobros, Integer> nroRecibo;
    public static volatile SingularAttribute<Cobros, Integer> idCobro;
    public static volatile SingularAttribute<Cobros, Date> fechaCobro;
    public static volatile SingularAttribute<Cobros, BigDecimal> montoCobro;
    public static volatile ListAttribute<Cobros, CobrosDet> cobrosDetList;

}