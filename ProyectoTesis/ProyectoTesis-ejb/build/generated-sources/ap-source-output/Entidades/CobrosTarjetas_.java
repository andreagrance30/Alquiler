package Entidades;

import Entidades.Cobros;
import Entidades.Tarjetas;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(CobrosTarjetas.class)
public class CobrosTarjetas_ { 

    public static volatile SingularAttribute<CobrosTarjetas, Tarjetas> idTarjeta;
    public static volatile SingularAttribute<CobrosTarjetas, Integer> idCobroTarjeta;
    public static volatile SingularAttribute<CobrosTarjetas, Integer> nroTarjeta;
    public static volatile SingularAttribute<CobrosTarjetas, Integer> nroTicket;
    public static volatile SingularAttribute<CobrosTarjetas, BigDecimal> montoTarjeta;
    public static volatile SingularAttribute<CobrosTarjetas, Cobros> idCobro;

}