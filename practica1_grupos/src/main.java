import java.util.*;

public class main {
    public static void main(String[] args) {
        Escuela escuela = new Escuela(1, "Escuela Técnica", new ArrayList<>());

        DivisionCurso division = new DivisionCurso(101, 2025, 1, new ArrayList<>());

        Catedra matematica = new Catedra(1, "Matemática", new ArrayList<>());

        Alumno juan = new Alumno(1001, "Juan", "Pérez", getFecha(2005, 3, 15), new ArrayList<>());
        Alumno ana = new Alumno(1002, "Ana", "López", getFecha(2005, 5, 22), new ArrayList<>());

        for (int i = 0; i < 6; i++) {
            Nota nota = new Nota(i + 1, 8, new Date(), false, matematica);
            juan.getNotas().add(nota);
        }

        for (int i = 0; i < 5; i++) {
            Nota nota = new Nota(i + 10, i == 0 ? 5 : 9, new Date(), false, matematica);
            ana.getNotas().add(nota);
        }

        matematica.getAlumnos().add(juan);
        matematica.getAlumnos().add(ana);

        division.getCatedras().add(matematica);
        escuela.getDivisiones().add(division);

        Alumno mejor = escuela.getMejorAlumnoEscuela(2005);
        System.out.println("Mejor alumno de 2005: " +
                (mejor != null ? mejor.getNombre() + " " + mejor.getApellido() : "ninguno"));

        List<Alumno> top3 = escuela.getMejoresAlumnos(2005);
        System.out.println("Top 3 alumnos de 2005:");
        for (Alumno a : top3) {
            System.out.println(a.getNombre() + " " + a.getApellido());
        }
    }

    private static Date getFecha(int anio, int mes, int dia) {
        Calendar cal = Calendar.getInstance();
        cal.set(anio, mes - 1, dia);
        return cal.getTime();
    }
}
