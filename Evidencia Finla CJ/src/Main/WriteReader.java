package Main;
import java.io.*;

public class WriteReader {

    public void escribirObjeto(Object object, String file) throws IOException{
        FileOutputStream f = new FileOutputStream(new File(file));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(object);
        o.flush();
        o.close();
        f.close();
    }

    public Object leerObjeto(String file) throws IOException, ClassNotFoundException{
        FileInputStream f1 = new FileInputStream(new File(file));
        ObjectInputStream o1 = new ObjectInputStream(f1);
        Object object= (Object) o1.readObject();
        o1.close();
        f1.close();
        return object;
    }

}
