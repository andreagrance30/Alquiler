package Entidades;

import Entidades.Personas;
import Entidades.SolicitudesPedidos;
import Entidades.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> estado;
    public static volatile SingularAttribute<Clientes, Integer> idCliente;
    public static volatile ListAttribute<Clientes, Ventas> ventasList;
    public static volatile ListAttribute<Clientes, SolicitudesPedidos> solicitudesPedidosList;
    public static volatile SingularAttribute<Clientes, Personas> personas;

}