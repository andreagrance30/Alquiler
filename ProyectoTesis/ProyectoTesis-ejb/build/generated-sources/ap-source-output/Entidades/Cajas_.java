package Entidades;

import Entidades.AperturaCierreCaja;
import Entidades.Sucursales;
import Entidades.Timbrados;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Cajas.class)
public class Cajas_ { 

    public static volatile SingularAttribute<Cajas, Sucursales> idSucursal;
    public static volatile SingularAttribute<Cajas, String> estado;
    public static volatile ListAttribute<Cajas, Timbrados> timbradosList;
    public static volatile SingularAttribute<Cajas, Integer> idCaja;
    public static volatile ListAttribute<Cajas, AperturaCierreCaja> aperturaCierreCajaList;
    public static volatile SingularAttribute<Cajas, BigInteger> puntoEmision;

}