package storage;

import model.Topping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToppingReaderWriterFile {
    private static ToppingReaderWriterFile toppingReaderWriterFile;
    private ToppingReaderWriterFile(){}
    public List<Topping> fileReader() throws IOException, ClassNotFoundException {
        File file = new File("toppinglist.dat");


        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            List<Topping> list = (List<Topping>) ois.readObject();

            ois.close();
            is.close();
            return list;
        } else return new ArrayList<>();
    }
    public void fileWriter(List<Topping> toppings) throws IOException {
        FileOutputStream os = new FileOutputStream("toppinglist.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos = new ObjectOutputStream(os);
        oos.close();
        os.close();
    }
}
