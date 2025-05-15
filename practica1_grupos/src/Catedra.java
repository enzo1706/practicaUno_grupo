import java.util.List;

public class Catedra {

    private int codigo;
    private String denominacion;
    private List<Alumno> alumnos;

    public Catedra(int codigo, String denominacion, List<Alumno> alumnos) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.alumnos = alumnos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Alumno mejorAlumnoCatedra(){
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        for (Alumno alumnos : alumnos){
            double promedio = alumnos.promedioNotas(this.codigo);

            if (mejorAlumno == null || promedio > mejorPromedio){
                mejorAlumno = alumnos;
                mejorPromedio = promedio;
            }
        }
        return mejorAlumno;
    }


}
