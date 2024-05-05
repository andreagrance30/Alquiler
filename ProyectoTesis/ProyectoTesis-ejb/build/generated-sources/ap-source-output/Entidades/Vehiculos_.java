package Entidades;

import Entidades.Intinerarios;
import Entidades.Marcas;
import Entidades.Modelos;
import Entidades.NotasRemisiones;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Vehiculos.class)
public class Vehiculos_ { 

    public static volatile SingularAttribute<Vehiculos, String> nroChapa;
    public static volatile SingularAttribute<Vehiculos, String> nroChasis;
    public static volatile SingularAttribute<Vehiculos, Integer> idVehiculo;
    public static volatile SingularAttribute<Vehiculos, String> color;
    public static volatile ListAttribute<Vehiculos, NotasRemisiones> notasRemisionesList;
    public static volatile ListAttribute<Vehiculos, Intinerarios> intinerariosList;
    public static volatile SingularAttribute<Vehiculos, BigDecimal> anho;
    public static volatile SingularAttribute<Vehiculos, Modelos> idModelo;
    public static volatile SingularAttribute<Vehiculos, Marcas> idMarca;

}