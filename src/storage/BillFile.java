package storage;

import model.Bill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BillFile {
    private static BillFile billFile;

    private BillFile() {
    }
    public static BillFile getInstance(){
        if (billFile == null){
            billFile = new BillFile();
        }
        return billFile;
    }

    public List<Bill> fileReader() throws IOException, ClassNotFoundException {
        File file = new File("billlist.dat");


        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            List<Bill> list = (List<Bill>) ois.readObject();

            ois.close();
            is.close();
            return list;
        } else return new ArrayList<>();

    }


    public void fileWriter(List<Bill> bills) throws IOException {
        FileOutputStream os = new FileOutputStream("billlist.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos = new ObjectOutputStream(os);
        oos.close();
        os.close();
    }

}

