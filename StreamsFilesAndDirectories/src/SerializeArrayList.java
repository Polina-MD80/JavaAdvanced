import java.io.*;
import java.util.List;

public
class SerializeArrayList {
    public static
    void main (String[] args) throws IOException, ClassNotFoundException {
        String path = "C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser";
        List<Double> list = List.of (4.5,6.6,3.5,5.7);
        FileOutputStream fos = new FileOutputStream (path);
        ObjectOutputStream oos = new ObjectOutputStream (fos);
        oos.writeObject (list);

        FileInputStream fis = new FileInputStream (path);
        ObjectInputStream ois = new ObjectInputStream (fis);

        List<Double> deserializedList = (List<Double>)ois.readObject ();
        deserializedList.forEach(e -> System.out.println(e));


    }
}
