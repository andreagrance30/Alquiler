package Entidades;

import Entidades.Clientes;
import Entidades.Empleados;
import Entidades.Proveedores;
import Entidades.TiposPersonas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Personas.class)
public class Personas_ { 

    public static volatile SingularAttribute<Personas, String> ruc;
    public static volatile SingularAttribute<Personas, String> segundoNombre;
    public static volatile SingularAttribute<Personas, String> primerNombre;
    public static volatile SingularAttribute<Personas, String> primerApellido;
    public static volatile SingularAttribute<Personas, String> cedulaIdentidad;
    public static volatile SingularAttribute<Personas, String> direccion;
    public static volatile SingularAttribute<Personas, String> segundoApellido;
    public static volatile SingularAttribute<Personas, Empleados> empleados;
    public static volatile SingularAttribute<Personas, Proveedores> proveedores;
    public static volatile SingularAttribute<Personas, TiposPersonas> idTipoPersona;
    public static volatile SingularAttribute<Personas, String> telefono;
    public static volatile SingularAttribute<Personas, Clientes> clientes;
    public static volatile SingularAttribute<Personas, Integer> idPersona;

}