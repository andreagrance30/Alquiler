package Entidades;

import Entidades.ArqueosCajas;
import Entidades.Cajas;
import Entidades.Cobros;
import Entidades.RecaudacionesDepositar;
import Entidades.UsuariosSucursales;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(AperturaCierreCaja.class)
public class AperturaCierreCaja_ { 

    public static volatile SingularAttribute<AperturaCierreCaja, BigInteger> difMontoTarjetaCierre;
    public static volatile SingularAttribute<AperturaCierreCaja, BigInteger> difMontoChequeCierre;
    public static volatile ListAttribute<AperturaCierreCaja, ArqueosCajas> arqueosCajasList;
    public static volatile SingularAttribute<AperturaCierreCaja, BigInteger> montoChequeCierre;
    public static volatile SingularAttribute<AperturaCierreCaja, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<AperturaCierreCaja, BigInteger> montoTarjetaCierre;
    public static volatile ListAttribute<AperturaCierreCaja, RecaudacionesDepositar> recaudacionesDepositarList;
    public static volatile SingularAttribute<AperturaCierreCaja, BigInteger> difMontoEfectivoCierre;
    public static volatile SingularAttribute<AperturaCierreCaja, Date> fechaCierre;
    public static volatile ListAttribute<AperturaCierreCaja, Cobros> cobrosList;
    public static volatile SingularAttribute<AperturaCierreCaja, Integer> idAperturaCierreCaja;
    public static volatile SingularAttribute<AperturaCierreCaja, Date> fechaApertura;
    public static volatile SingularAttribute<AperturaCierreCaja, BigInteger> montoEfectivoCierre;
    public static volatile SingularAttribute<AperturaCierreCaja, BigInteger> montoInicial;
    public static volatile SingularAttribute<AperturaCierreCaja, Cajas> idCaja;

}