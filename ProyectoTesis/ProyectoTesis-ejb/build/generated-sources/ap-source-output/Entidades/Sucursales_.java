package Entidades;

import Entidades.Cajas;
import Entidades.Depositos;
import Entidades.UsuariosSucursales;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Sucursales.class)
public class Sucursales_ { 

    public static volatile SingularAttribute<Sucursales, Integer> idSucursal;
    public static volatile SingularAttribute<Sucursales, String> descripcion;
    public static volatile ListAttribute<Sucursales, Cajas> cajasList;
    public static volatile ListAttribute<Sucursales, UsuariosSucursales> usuariosSucursalesList;
    public static volatile SingularAttribute<Sucursales, String> direccion;
    public static volatile ListAttribute<Sucursales, Depositos> depositosList;
    public static volatile SingularAttribute<Sucursales, BigInteger> puntoEstablecimiento;
    public static volatile SingularAttribute<Sucursales, String> telefono;

}