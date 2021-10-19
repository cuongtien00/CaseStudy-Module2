package controller;

import model.Topping;
import storage.ToppingReaderWriterFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToppingManager {
    private  List<Topping> toppings;
    private ToppingReaderWriterFile toppingReaderWriterFile;

    public ToppingManager() {
        toppings = new ArrayList<>();
    }
    public void addNewTop(Topping topping) throws IOException {
        toppings.add(topping);
        toppingReaderWriterFile.fileWriter(toppings);
    }
    public void removeT(int index) throws IOException {
        toppings.remove(index);
        toppingReaderWriterFile.fileWriter(toppings);
    }
    public void editTop(int index, Topping topping) throws IOException {
        toppings.set(index,topping);
        toppingReaderWriterFile.fileWriter(toppings);
    }
    public void showList(){
        for (Topping a:toppings) {
            System.out.println(a);
        }
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
