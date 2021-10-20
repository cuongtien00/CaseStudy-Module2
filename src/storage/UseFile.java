package storage;

import model.MilkTea;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UseFile {
    private static UseFile useFile;

    private UseFile() {
    }
    public static UseFile getInstance(){
        if(useFile == null){
            useFile = new UseFile();
        }
        return useFile;
    }
    public List<User> fileReader() throws IOException, ClassNotFoundException {
        File file = new File("user.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        if(file.length()>0){
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            List<User> list = (List<User>) ois.readObject();

            ois.close();
            is.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void fileWriter(List<User> userList) throws IOException {
        FileOutputStream os = new FileOutputStream("user.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(userList);
        oos.close();
        os.close();
    }
}
