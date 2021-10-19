package storage;

import model.Customer;
import model.MilkTea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerReaderWriterFile {
    private static CustomerReaderWriterFile customerReaderWriterFile;
    private CustomerReaderWriterFile(){}
    public static CustomerReaderWriterFile getInstance(){
        if (customerReaderWriterFile == null){
            customerReaderWriterFile = new CustomerReaderWriterFile();
        }
        return customerReaderWriterFile;
    }

    public List<Customer> fileReader() throws IOException, ClassNotFoundException {
        File file = new File("customer.dat");
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
        FileOutputStream os = new FileOutputStream("customer.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(customers);
        oos.close();
        os.close();
    }
}
