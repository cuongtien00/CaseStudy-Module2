package storage;

import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerFile {
    private static CustomerFile customerFile;
    private CustomerFile(){}
    public static CustomerFile getInstance(){
        if (customerFile == null){
            customerFile = new CustomerFile();
        }
        return customerFile;
    }

    public List<Customer> fileReader() throws IOException, ClassNotFoundException {
        File file = new File("customerlist.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        if(file.length()>0){
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object object = ois.readObject();
            List<Customer> list = (List<Customer>) object;

            ois.close();
            is.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void fileWriter(List<Customer> customers) throws IOException {
        FileOutputStream os = new FileOutputStream("customerlist.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(customers);
        oos.close();
        os.close();
    }
}
