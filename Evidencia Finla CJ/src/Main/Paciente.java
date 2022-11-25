
package Main;

import java.io.Serializable;
public class Paciente implements Serializable{
    private String id;
    private String nombre;

    public Paciente(){

    }

    public Paciente(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public String getId(){
        return id;
    }
    public void getId (String id) {
        ;
        this.id = id;
    }

    public String getNombre(String s) {
        return nombre;
    }

    public void sctNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "paciente(" +
                "+id" + id
                +",nombre" + nombre +"/"
                +"]";
    }
}

