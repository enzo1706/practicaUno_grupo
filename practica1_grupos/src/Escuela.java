import java.util.*;

public class Escuela {
    private int numero;
    private String denominacion;
    private List<DivisionCurso> divisiones;

    public Escuela(int numero, String denominacion, List<DivisionCurso> divisiones) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.divisiones = divisiones;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<DivisionCurso> getDivisiones() {
        return divisiones;
    }

    public void setDivisiones(List<DivisionCurso> divisiones) {
        this.divisiones = divisiones;
    }

    public Alumno getMejorAlumnoEscuela(int anioNacimientoAlumno) {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        Set<Alumno> alumnosUnicos = new HashSet<>();

        for (DivisionCurso division : divisiones) {
            for (Catedra catedra : division.getCatedras()) {
                alumnosUnicos.addAll(catedra.getAlumnos());
            }
        }

        for (Alumno alumno : alumnosUnicos) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(alumno.getFechaNacimiento());
            int anioNacimiento = cal.get(Calendar.YEAR);

            if (anioNacimiento != anioNacimientoAlumno) {
                continue;
            }

            boolean desaprobo = false;
            double suma = 0;
            int cantidad = 0;

            for (Nota nota : alumno.getNotas()) {
                if (nota.getValor() < 6) {
                    desaprobo = true;
                    break;
                }
                suma += nota.getValor();
                cantidad++;
            }

            if (desaprobo || cantidad == 0) {
                continue;
            }

            double promedio = suma / cantidad;

            if (mejorAlumno == null || promedio > mejorPromedio) {
                mejorAlumno = alumno;
                mejorPromedio = promedio;
            }
        }

        return mejorAlumno;
    }

    public List<Alumno> getMejoresAlumnos(int anioNacimientoAlumno) {
        List<clase_auxiliar_AlumnoConPromedio> candidatos = new ArrayList<>();

        Set<Alumno> alumnosUnicos = new HashSet<>();
        for (DivisionCurso division : divisiones) {
            for (Catedra catedra : division.getCatedras()) {
                alumnosUnicos.addAll(catedra.getAlumnos());
            }
        }

        for (Alumno alumno : alumnosUnicos) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(alumno.getFechaNacimiento());
            int anio = cal.get(Calendar.YEAR);

            if (anio != anioNacimientoAlumno) continue;

            boolean desaprobo = false;
            double suma = 0;
            int cantidad = 0;

            for (Nota nota : alumno.getNotas()) {
                if (nota.getValor() < 6) {
                    desaprobo = true;
                    break;
                }
                suma += nota.getValor();
                cantidad++;
            }

            if (!desaprobo && cantidad > 0) {
                double promedio = suma / cantidad;
                candidatos.add(new clase_auxiliar_AlumnoConPromedio(alumno, promedio));
            }
        }

        candidatos.sort((a1, a2) -> Double.compare(a2.promedio, a1.promedio));

        List<Alumno> resultado = new ArrayList<>();
        for (int i = 0; i < Math.min(3, candidatos.size()); i++) {
            resultado.add(candidatos.get(i).alumno);
        }

        return resultado;
    }
}