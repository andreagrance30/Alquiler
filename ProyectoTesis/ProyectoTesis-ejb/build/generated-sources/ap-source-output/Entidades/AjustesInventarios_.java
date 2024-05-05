package Entidades;

import Entidades.Stock;
import Entidades.UsuariosSucursales;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(AjustesInventarios.class)
public class AjustesInventarios_ { 

    public static volatile SingularAttribute<AjustesInventarios, Integer> idAjusteInventario;
    public static volatile SingularAttribute<AjustesInventarios, String> motivo;
    public static volatile SingularAttribute<AjustesInventarios, String> estado;
    public static volatile SingularAttribute<AjustesInventarios, BigInteger> existenciaFisica;
    public static volatile SingularAttribute<AjustesInventarios, BigInteger> existenciaTeorica;
    public static volatile SingularAttribute<AjustesInventarios, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<AjustesInventarios, Stock> stock;

}