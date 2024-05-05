package Entidades;

import Entidades.Stock;
import Entidades.Sucursales;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(Depositos.class)
public class Depositos_ { 

    public static volatile SingularAttribute<Depositos, String> descripcion;
    public static volatile SingularAttribute<Depositos, Sucursales> idSucursal;
    public static volatile ListAttribute<Depositos, Stock> stockList;
    public static volatile SingularAttribute<Depositos, Integer> idDeposito;

}