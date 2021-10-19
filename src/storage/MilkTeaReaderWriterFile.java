package storage;

import model.MilkTea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MilkTeaReaderWriterFile {
    private static MilkTeaReaderWriterFile milkTeaReaderWriterFile;

    private MilkTeaReaderWriterFile() {
    }
    public List<MilkTea> fileReader() throws IOException, ClassNotFoundException {
        File file = new File("milktea.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        if(file.length()>0){
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            List<MilkTea> list = (List<MilkTea>) ois.readObject();

            ois.close();
            is.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void fileWriter(List<MilkTea> milkTeas) throws IOException {
        FileOutputStream os = new FileOutputStream("milktea.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(milkTeas);
        oos.close();
        os.close();
    }
}