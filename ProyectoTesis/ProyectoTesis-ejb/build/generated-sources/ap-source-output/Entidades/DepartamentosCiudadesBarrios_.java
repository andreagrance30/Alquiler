package Entidades;

import Entidades.Barrios;
import Entidades.Ciudades;
import Entidades.Departamentos;
import Entidades.DepartamentosCiudadesBarriosPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-05T16:41:50")
@StaticMetamodel(DepartamentosCiudadesBarrios.class)
public class DepartamentosCiudadesBarrios_ { 

    public static volatile SingularAttribute<DepartamentosCiudadesBarrios, DepartamentosCiudadesBarriosPK> departamentosCiudadesBarriosPK;
    public static volatile SingularAttribute<DepartamentosCiudadesBarrios, Departamentos> departamentos;
    public static volatile SingularAttribute<DepartamentosCiudadesBarrios, Barrios> barrios;
    public static volatile SingularAttribute<DepartamentosCiudadesBarrios, Ciudades> ciudades;

}