package Entidades;

import Entidades.Empleados;
import Entidades.NotasRemisionesDet;
import Entidades.Timbrados;
import Entidades.UsuariosSucursales;
import Entidades.Vehiculos;
import Entidades.Ventas;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(NotasRemisiones.class)
public class NotasRemisiones_ { 

    public static volatile SingularAttribute<NotasRemisiones, String> nroComprobante;
    public static volatile SingularAttribute<NotasRemisiones, String> estado;
    public static volatile SingularAttribute<NotasRemisiones, String> motivo;
    public static volatile SingularAttribute<NotasRemisiones, Vehiculos> idVehiculo;
    public static volatile SingularAttribute<NotasRemisiones, String> direccionLlegada;
    public static volatile SingularAttribute<NotasRemisiones, UsuariosSucursales> usuariosSucursales;
    public static volatile SingularAttribute<NotasRemisiones, Date> fechaEmision;
    public static volatile SingularAttribute<NotasRemisiones, Date> fechaFin;
    public static volatile SingularAttribute<NotasRemisiones, Ventas> idVenta;
    public static volatile ListAttribute<NotasRemisiones, NotasRemisionesDet> notasRemisionesDetList;
    public static volatile SingularAttribute<NotasRemisiones, Integer> idNotaRemision;
    public static volatile SingularAttribute<NotasRemisiones, Date> fechaInicio;
    public static volatile SingularAttribute<NotasRemisiones, Empleados> idEmpleado;
    public static volatile SingularAttribute<NotasRemisiones, String> direccionPartida;
    public static volatile SingularAttribute<NotasRemisiones, Timbrados> idTimbrado;
    public static volatile SingularAttribute<NotasRemisiones, Date> fechaVenc;
    public static volatile SingularAttribute<NotasRemisiones, BigInteger> nroTimbrado;

}