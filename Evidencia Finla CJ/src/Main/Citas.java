package Main;
import java.io.Serializable;
public class Citas implements Serializable{
    private String id;
    private String fecha;
    private String hora;
    private String motivo;

    public Citas(){

    }

    public Citas (String id, String fecha, String hora, String motivo){
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }
    public String getId(){
        return id;
    }
    public void getId(String id){
        this.id = id;
    }

    public String getFecha(){
        return fecha;
    }

    public void getfecha(String fecha){
        this.fecha = fecha;
    }
    public String getHora(){
        return hora;
    }

    public void getHora(String hora){
        this.fecha = fecha;
    }

    public String getMotivo(){
        return motivo;
    }
    public void getmotivo(String motivo){
        this.motivo = motivo;
    }

    @Override
    public String toString(){
        return "Cita("
                +"id" + id
                +"fecha" + fecha
                +"hora" + hora
                +"motivo" + motivo
                +")";
    }


}
