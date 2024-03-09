package Entidades;

import Entidades.IntinerariosDet;
import Entidades.UsuariosSucursales;
import Entidades.Vehiculos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Intinerarios.class)
public class Intinerarios_ { 

    public static volatile SingularAttribute<Intinerarios, Vehiculos> idVehiculo;
    public static volatile SingularAttribute<Intinerarios, Date> fechaIntinerario;
    public static volatile ListAttribute<Intinerarios, IntinerariosDet> intinerariosDetList;
    public static volatile SingularAttribute<Intinerarios, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<Intinerarios, Integer> idIntinerario;

}