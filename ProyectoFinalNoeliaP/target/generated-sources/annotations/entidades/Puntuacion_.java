package entidades;

import entidades.Obra;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T23:39:25", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Puntuacion.class)
public class Puntuacion_ { 

    public static volatile SingularAttribute<Puntuacion, Integer> puntuacion;
    public static volatile SingularAttribute<Puntuacion, Obra> obraId;
    public static volatile SingularAttribute<Puntuacion, Integer> idpuntu;
    public static volatile SingularAttribute<Puntuacion, String> comentario;

}