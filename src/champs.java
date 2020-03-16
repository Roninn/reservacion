
/**
 *
 * @author pvtra
 */
import java.util.Date;
public class champs {
    String fecha;
    String espacio;
    String hora;
    int IDUSU;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public int getId() {
        return IDUSU;
    }

    public void setId(int IDUSU) {
        this.IDUSU = IDUSU;
    }

    public champs(String fecha, String espacio, String hora, int IDUSU) {
        this.fecha = fecha;
        this.espacio = espacio;
        this.hora = hora;
        this.IDUSU = IDUSU;
    }
}
