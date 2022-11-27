package ar.charlycimino.cac.crud.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */

// Modelo HC (Hard Codeado): Los datos se guardan en la RAM. Solo sirve para testear la app.
public class ModeloHC implements Modelo {

    private List<Alumno> alumnosGuardados;

    public ModeloHC() {
        this.alumnosGuardados = new ArrayList<>();
        crearAlumnosFake();
    }

    @Override
    public List<Alumno> getAlumnos() {
        return new ArrayList(this.alumnosGuardados); // Copia de la lista original
    }

    @Override
    public Alumno getAlumno(int id) {
        int i = 0;
        Alumno encontrado = null;
        while (i < this.alumnosGuardados.size() && encontrado == null) {
            Alumno a = this.alumnosGuardados.get(i);
            if (a.getId() == id) {
                encontrado = a;
            } else {
                i++;
            }
        }
        if (encontrado == null) {
            throw new RuntimeException("No se encontró alumno con ID " + id);
        }
        return encontrado;
    }

    @Override
    public int addAlumno(Alumno alumno) {
        this.alumnosGuardados.add(alumno);
        return 0;
    }

    @Override
    public int updateAlumno(Alumno a) {
        Alumno target = getAlumno(a.getId());
        int idx = this.alumnosGuardados.indexOf(target);
        this.alumnosGuardados.set(idx, a);
        return 0;
    }

    @Override
    public int removeAlumno(int id) {
        Alumno target = getAlumno(id);
        this.alumnosGuardados.remove(target);
        return 0;
    }

    private void crearAlumnosFake() {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("carasFake.properties")) {
            Properties props = new Properties();
            props.load(is);
            this.alumnosGuardados.add(new Alumno(1, "Kouza", "Ibrahim (HC)", "kouibr@mailsrv.fake", "1999-06-22", (String) props.get("HOMBRE_1")));
            this.alumnosGuardados.add(new Alumno(2, "Polo", "Irma", "irmapolo@mailsrv.fake", "1991-02-28"));
            this.alumnosGuardados.add(new Alumno(3, "López", "María", "maria_lopez@mailsrv.fake", "1984-03-24", (String) props.get("MUJER_1")));
            this.alumnosGuardados.add(new Alumno(4, "García", "Luis", "luis123@mailsrv.fake", "1998-07-04", (String) props.get("HOMBRE_3")));
            this.alumnosGuardados.add(new Alumno(5, "Gómez", "Sara", "saragomez@mailsrv.fake", "1991-02-28", (String) props.get("MUJER_3")));
            this.alumnosGuardados.add(new Alumno(6, "Ruiz", "Pedro", "ruiz.pedro@mailsrv.fake", "1986-11-13", (String) props.get("HOMBRE_2")));
            this.alumnosGuardados.add(new Alumno(7, "Pérez", "Lía", "lp12@mailsrv.fake", "1968-07-12", (String) props.get("MUJER_2")));
            this.alumnosGuardados.add(new Alumno(8, "Suárez", "Ana", "suanan@mailsrv.fake", "1992-05-16", (String) props.get("MUJER_4")));
            this.alumnosGuardados.add(new Alumno(9, "Mohamed", "Samuel", "samo@mailsrv.fake", "1990-05-14", (String) props.get("HOMBRE_4")));
        } catch (IOException ex) {
            throw new RuntimeException("No se pudieron cargar las caras fake");
        }
    }
}
