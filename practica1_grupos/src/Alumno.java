import java.util.Date;
import java.util.List;

public class Alumno {
    private long legajo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private List<Nota> notas;

    public Alumno(long legajo, String nombre, String apellido, Date fechaNacimiento, List<Nota> notas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.notas = notas;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }



    public Nota mejorNota(Integer codigoCatedra){
        Nota mejorNota = null;
      for (Nota not : notas){
          if (not.isEsRecuperatorio()){
              continue;
          }

          if (codigoCatedra != null && not.getCatedra().getCodigo() != codigoCatedra){
              continue;
          }

          if (mejorNota == null || not.getValor() > mejorNota.getValor()){
              mejorNota = not;
          }
      }
      return mejorNota;
    }

    public double promedioNotas(Integer codigoCatedra){
        double suma = 0;
        int cantidad = 0;

        for (Nota nota : notas){
            if (codigoCatedra != null && nota.getCatedra().getCodigo() != codigoCatedra){
                continue;
            }

            suma += nota.getValor();
            cantidad++;
        }
        return cantidad > 0 ? (suma / cantidad) : 0.0;
    }
}


