package Entidades;

import Entidades.Stock;
import Entidades.UsuariosSucursales;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(AjustesInventarios.class)
public class AjustesInventarios_ { 

    public static volatile SingularAttribute<AjustesInventarios, Integer> idAjusteInventario;
    public static volatile SingularAttribute<AjustesInventarios, String> motivo;
    public static volatile SingularAttribute<AjustesInventarios, String> estado;
    public static volatile SingularAttribute<AjustesInventarios, BigDecimal> existenciaFisica;
    public static volatile SingularAttribute<AjustesInventarios, BigDecimal> existenciaTeorica;
    public static volatile SingularAttribute<AjustesInventarios, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<AjustesInventarios, Stock> stock;

}