package Entidades;

import Entidades.Empleados;
import Entidades.Roles;
import Entidades.Terminales;
import Entidades.UsuariosSucursales;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Roles> idRol;
    public static volatile SingularAttribute<Usuarios, String> pass;
    public static volatile SingularAttribute<Usuarios, Empleados> idEmpleado;
    public static volatile ListAttribute<Usuarios, UsuariosSucursales> usuariosSucursalesList;
    public static volatile SingularAttribute<Usuarios, String> idUsuario;
    public static volatile SingularAttribute<Usuarios, Terminales> idTerminal;

}