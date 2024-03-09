package Entidades;

import Entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, String> descripcion;
    public static volatile ListAttribute<Roles, Usuarios> usuariosList;
    public static volatile SingularAttribute<Roles, Integer> idRol;

}