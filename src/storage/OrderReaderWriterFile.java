package storage;

import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderReaderWriterFile {
    private static OrderReaderWriterFile orderReaderWriterFile;

    private OrderReaderWriterFile() {
    }

    public List<Order> FileReader() throws IOException, ClassNotFoundException {
        File file = new File("orderlist.dat");


        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            List<Order> list = (List<Order>) ois.readObject();

            ois.close();
            is.close();
            return list;
        } else return new ArrayList<>();

    }


    public void fileWriter(List<Order> orders) throws IOException {
        FileOutputStream os = new FileOutputStream("orderlist.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos = new ObjectOutputStream(os);
        oos.close();
        os.close();


    }
}

