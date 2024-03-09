package Entidades;

import Entidades.Cajas;
import Entidades.NotasCreditos;
import Entidades.NotasDebitos;
import Entidades.NotasRemisiones;
import Entidades.TiposComprobantes;
import Entidades.Ventas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Timbrados.class)
public class Timbrados_ { 

    public static volatile SingularAttribute<Timbrados, String> estado;
    public static volatile ListAttribute<Timbrados, NotasCreditos> notasCreditosList;
    public static volatile ListAttribute<Timbrados, Ventas> ventasList;
    public static volatile SingularAttribute<Timbrados, BigDecimal> nroActual;
    public static volatile SingularAttribute<Timbrados, Date> fechaFin;
    public static volatile SingularAttribute<Timbrados, Date> fechaCarga;
    public static volatile SingularAttribute<Timbrados, Date> fechaInicio;
    public static volatile SingularAttribute<Timbrados, BigDecimal> nroInicial;
    public static volatile SingularAttribute<Timbrados, BigDecimal> nroFinal;
    public static volatile ListAttribute<Timbrados, NotasDebitos> notasDebitosList;
    public static volatile SingularAttribute<Timbrados, TiposComprobantes> idTipoComprobante;
    public static volatile ListAttribute<Timbrados, NotasRemisiones> notasRemisionesList;
    public static volatile SingularAttribute<Timbrados, Integer> idTimbrado;
    public static volatile SingularAttribute<Timbrados, Cajas> idCaja;
    public static volatile SingularAttribute<Timbrados, BigDecimal> nroTimbrado;

}