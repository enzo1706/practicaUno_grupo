import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivisionCurso {
    private int codigo;
    private int anio;
    private int division;
    private List<Catedra> catedras;

    public DivisionCurso(int codigo, int anio, int division, List<Catedra> catedras) {
        this.codigo = codigo;
        this.anio = anio;
        this.division = division;
        this.catedras = catedras;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public List<Catedra> getCatedras() {
        return catedras;
    }

    public void setCatedras(List<Catedra> catedras) {
        this.catedras = catedras;
    }

    public Alumno mejorAlumnoDivisionCurso(){
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        Set<Alumno> alumnosUnicos = new HashSet<>();

        for (Catedra c : catedras){
            alumnosUnicos.addAll(c.getAlumnos());
        }

        for (Alumno a : alumnosUnicos) {
            List<Nota> notasValidas = new ArrayList<>();

            for (Nota n : a.getNotas()) {
                if (!n.isEsRecuperatorio()) {
                    notasValidas.add(n);
                }
            }

            if (notasValidas.size() > 5) {
                continue;
            }

            double suma = 0;
            for (Nota nota : notasValidas) {
                suma += nota.getValor();
            }

            double promedio = suma / notasValidas.size();

            if (mejorAlumno == null || promedio > mejorPromedio){
                mejorAlumno = a;
                mejorPromedio = promedio;
            }
        }
        return mejorAlumno;
    }

}
