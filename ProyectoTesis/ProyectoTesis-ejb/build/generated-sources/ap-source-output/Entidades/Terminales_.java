package Entidades;

import Entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Terminales.class)
public class Terminales_ { 

    public static volatile SingularAttribute<Terminales, String> descripcion;
    public static volatile ListAttribute<Terminales, Usuarios> usuariosList;
    public static volatile SingularAttribute<Terminales, Integer> idTerminal;

}