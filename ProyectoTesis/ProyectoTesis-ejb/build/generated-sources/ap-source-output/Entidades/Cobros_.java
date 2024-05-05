package Entidades;

import Entidades.AperturaCierreCaja;
import Entidades.CobrosCheques;
import Entidades.CobrosDet;
import Entidades.CobrosFormasDet;
import Entidades.CobrosTarjetas;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
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
    public static volatile SingularAttribute<Cobros, BigInteger> montoCobro;
    public static volatile ListAttribute<Cobros, CobrosDet> cobrosDetList;

}