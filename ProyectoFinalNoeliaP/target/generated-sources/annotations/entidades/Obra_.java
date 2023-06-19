package entidades;

import entidades.Puntuacion;
import entidades.Usuario;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T23:39:25", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Obra.class)
public class Obra_ { 

    public static volatile SingularAttribute<Obra, String> descripcion;
    public static volatile SingularAttribute<Obra, Usuario> autorId;
    public static volatile SingularAttribute<Obra, Puntuacion> puntuacion;
    public static volatile SingularAttribute<Obra, String> categoria;
    public static volatile SingularAttribute<Obra, Integer> añoPublicacion;
    public static volatile SingularAttribute<Obra, String> titulo;
    public static volatile SingularAttribute<Obra, Integer> idobra;

}