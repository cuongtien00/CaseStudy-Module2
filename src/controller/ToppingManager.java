package controller;

import model.Topping;
import storage.ToppingReaderWriterFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToppingManager {
    private static ToppingManager toppingManager;
    private static List<Topping>toppings = new ArrayList<>();
    private ToppingManager(){};
    public static ToppingManager getInstance(){
        if(toppingManager == null){
            toppingManager = new ToppingManager();
        }
        return toppingManager;
    }
    private ToppingReaderWriterFile toppingReaderWriterFile;

    public void addNewTop(Topping topping) {
        toppings.add(topping);
//        toppingReaderWriterFile.fileWriter(toppings);
    }
    public int findById(String id){
        for (Topping a:toppings) {
            if(a.getId().equalsIgnoreCase(id)){
                return toppings.indexOf(a);
            }
        }
        return -1;
    }
    public void removeT(String id) {
        int index = findById(id);
        toppings.remove(index);
//        toppingReaderWriterFile.fileWriter(toppings);
    }
    public void editTop(String id, Topping topping)  {
        int index = findById(id);
        toppings.set(index,topping);
//        toppingReaderWriterFile.fileWriter(toppings);
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
