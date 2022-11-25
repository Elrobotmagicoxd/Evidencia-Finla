package Main;
import java.io.Serializable;
public class Doctor implements Serializable{
    private String id;
    private String nombre;
    private String especialidad;


    public Doctor(){

    }
    public Doctor (String id, String nombre, String especialidad){
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    public String getId(){
        return id;
    }

    public void getId(String id){
        this.id = id;
    }

    public String getnombre(){
        return nombre;
    }
    public void getNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad(String s){
        return especialidad;
    }

    public void getepecialiada(String especialidad){
        this.especialidad = especialidad;
    }

    @Override
    public String toString(){
        return "Doctor"
                +"id" + id
                +"nombre"+nombre +"/"
                +"especialidad" + especialidad +"/"
                +"/";
    }
}


