package Entidades;

import Entidades.Compras;
import Entidades.OrdenesComprasDet;
import Entidades.Pedidos;
import Entidades.UsuariosSucursales;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(OrdenesCompras.class)
public class OrdenesCompras_ { 

    public static volatile SingularAttribute<OrdenesCompras, Integer> idOrdenCompra;
    public static volatile SingularAttribute<OrdenesCompras, String> estado;
    public static volatile ListAttribute<OrdenesCompras, Compras> comprasList;
    public static volatile SingularAttribute<OrdenesCompras, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<OrdenesCompras, Date> fechaEmision;
    public static volatile SingularAttribute<OrdenesCompras, Pedidos> idPedido;
    public static volatile ListAttribute<OrdenesCompras, OrdenesComprasDet> ordenesComprasDetList;

}