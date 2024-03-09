package Entidades;

import Entidades.CobrosTarjetas;
import Entidades.EntidadesEmisoras;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-09T14:52:35")
@StaticMetamodel(Tarjetas.class)
public class Tarjetas_ { 

    public static volatile SingularAttribute<Tarjetas, String> descripcion;
    public static volatile SingularAttribute<Tarjetas, Integer> idTarjeta;
    public static volatile SingularAttribute<Tarjetas, EntidadesEmisoras> idEntidadEmisora;
    public static volatile ListAttribute<Tarjetas, CobrosTarjetas> cobrosTarjetasList;

}