package Entidades;

import Entidades.Cargos;
import Entidades.NotasRemisiones;
import Entidades.OrdenesTrabajosDet;
import Entidades.Pedidos;
import Entidades.Personas;
import Entidades.Usuarios;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile ListAttribute<Empleados, Usuarios> usuariosList;
    public static volatile SingularAttribute<Empleados, Cargos> idCargo;
    public static volatile SingularAttribute<Empleados, String> estado;
    public static volatile ListAttribute<Empleados, OrdenesTrabajosDet> ordenesTrabajosDetList;
    public static volatile SingularAttribute<Empleados, Integer> idEmpleado;
    public static volatile SingularAttribute<Empleados, Date> fechaNacimiento;
    public static volatile ListAttribute<Empleados, NotasRemisiones> notasRemisionesList;
    public static volatile SingularAttribute<Empleados, BigInteger> salario;
    public static volatile ListAttribute<Empleados, Pedidos> pedidosList;
    public static volatile SingularAttribute<Empleados, Personas> personas;

}