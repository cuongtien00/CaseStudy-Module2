package controller;

import model.Topping;
import storage.ToppingFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToppingManager {
    private static ToppingManager toppingManager;
    private  List<Topping>toppings = new ArrayList<>();
    private ToppingFile toppingFile = ToppingFile.getInstance();
    private ToppingManager(){};
    public static ToppingManager getInstance(){
        if(toppingManager == null){
            toppingManager = new ToppingManager();
        }
        return toppingManager;
    }

    public ToppingFile getToppingFile() {
        return toppingFile;
    }

    public void setToppingFile(ToppingFile toppingFile) {
        this.toppingFile = toppingFile;
    }

    public void addNewTop(Topping topping) throws IOException {
        toppings.add(topping);
        toppingFile.fileWriter(toppings);
    }
    public int findById(String id){
        for (Topping a:toppings) {
            if(a.getId().equalsIgnoreCase(id)){
                return toppings.indexOf(a);
            }
        }
        return -1;
    }
    public void removeT(String id) throws IOException {
        int index = findById(id);
        toppings.remove(index);
        toppingFile.fileWriter(toppings);
    }
    public void editTop(String id, Topping topping) throws IOException {
        int index = findById(id);
        toppings.set(index,topping);
        toppingFile.fileWriter(toppings);
    }
    public void showList(){
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――TOPPING-MENU――――――――――――――――――――――――――――――――――――――――――――――――");
        for (Topping a:toppings) {
            System.out.println("                                            　　　　　  "+a);
        }
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――～⊝～⊝～⊝～――――――――――――――――――――――――――――――――――――――――――――――――");

    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
